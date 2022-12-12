package Sortieren;

import LagerHaus.Artikel;

import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;

public class Wartezimmer{

    Patient[] meineP;
    List<Patient> meinePList;

    private static String KrankheitenListe = "src/Sortieren/Krankheiten";
    public Wartezimmer(int pI)    {
        meineP = new Patient[pI];
        meinePList = new List <Patient>();
        for(int i = 0;i<meineP.length;i++) {
            double j = ((double)((int)(Math.random()*98+1))/10);
            //public Patient(int pID, String pKrankheit, double pGrad)
            Patient p = new Patient (i, "Krankheit", j);
            meineP = makeKranke( pI,KrankheitenListe);
            meinePList.append(p);
        }
    }

    public void newPatient(Patient pPatient) {
        if(pPatient !=null) {
            meinePList.append(pPatient);
            for(int i = 0;i<meineP.length;i++) {
                if(meineP[i] == null) {
                    meineP[i] = pPatient;
                    i = meineP.length;
                }
            }
        }
    }

    public void gibArrayAus(){
        System.out.println("++++++++++++++++++++++++++++++");
        System.out.println("Im Wartezimmer(Array) sitzen derzeit:");
        for(int i = 0; i<meineP.length; i++) {
            if(meineP[i] != null) {
                System.out.println("PID: " + meineP[i].getID()+
                        " PKrankheit: " + meineP[i].getKrankheit()+
                        " pGrad: " + meineP[i].getGrad());
            }
        }
        System.out.println("++++++++++++++++++++++++++++++"+"\n");
    }

    public void gibListAus(){
        System.out.println("++++++++++++++++++++++++++++++");
        System.out.println("Im Wartezimmer(List) sitzen derzeit:");
        meinePList.toFirst();
        while(meinePList.hasAccess()){
            Patient temp = meinePList.getContent();
            System.out.println("PID: " + temp.getID()+
                    " PKrankheit: " + temp.getKrankheit()+
                    " pGrad: " + temp.getGrad());
            meinePList.next();
        }
        System.out.println("++++++++++++++++++++++++++++++"+"\n");
    }

    private void swap (int i, int j){
        if (i>=0&&j>=0&&i<meineP.length&&j<meineP.length){
            Patient temp = meineP[i];
            meineP[i] = meineP[j];
            meineP[j] = temp;
        }
    }

    public static Patient[] makeKranke(int count, String adress){
        //Ausgabe Stack
        Patient[] patienten = new Patient[count];
        //String in den die Namen geladen werden
        StringBuilder krankheiten = null;
        //Versuch die Namen zu laden

        try {
            krankheiten = new StringBuilder(Files.readString(Path.of(adress)));
        } catch (IOException e) {
            //Namen File nicht lesbar
            throw new RuntimeException(e);
        }
        //while (krankheiten.length() < count){
            krankheiten.append("").append(krankheiten);
        //}
        System.out.println(krankheiten.length());
        //Aufteilung der Namen in ein Array
        //regex magie
        String[] namenArray = krankheiten.toString().split("\\t|\\r+\\n", count);

        namenArray[count-1] = namenArray[count-1].replaceAll("\\b\\W+\\w*","");
        //Erschaffung von "Patienten"
        for (int i = 0; i < count; i++){
            patienten[i] = new Patient(i, namenArray[i], ((double)((int)(Math.random()*98+1))/10));
        }
        return patienten;
    }

    public void BubbleSort(){
        int n = meineP.length;
        int steps = 0;
        for (int i = 0; i < n-1; i++){
            boolean swapped = false;
            for (int j = 0; j < n-i-1; j++){
                if (meineP[j].isGreater(meineP[j+1])){
                    swap(j, j+1);
                    swapped = true;
                    steps++;
                }
            }
            if (!swapped){
                i = meineP.length;
            }
        }
        System.out.println("Sortierte Objeckte:" + meineP.length + "Sortier schritte:" + steps);
    }
    public static void main(String[] args) {
        Wartezimmer einZimmer = new Wartezimmer(300);
        einZimmer.BubbleSort();
        einZimmer.gibArrayAus();
    }
}
