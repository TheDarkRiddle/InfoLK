package BinäreSuche;
import Sortieren.Patient;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


public class Main{
    Patient[]  EinArray;
    public Main(int pi){
        EinArray = makeKranke(pi, "C:\\Users\\derMo\\Programme\\Work\\InfoLK_Java\\InfoLK\\src\\Sortieren\\Krankheiten");

    }

    public static Patient[] makeKranke(int count, String adress){
        //Ausgabe DS
        Patient[] patienten = new Patient[count];
        //String in den die Namen geladen werden
        StringBuilder krankheiten;
        //----------------------------Versuch die Namen zu laden----------------------------
        try {
            krankheiten = new StringBuilder(Files.readString(Path.of(adress)));
        } catch (IOException e) {
            //Namen File nicht lesbar
            throw new RuntimeException(e);
        }
        //----------------------------Aufteilung der Namen in ein Array----------------------------
        //Testen und koriegieren des falles, dass mehr Patienten benötigt werden, als Krankheiten da sind.
        String[] namenArray = new String[0];
        StringBuilder temp = krankheiten;
        while (namenArray.length < count){
            //regex magie
            namenArray = krankheiten.append(temp).toString().split("\t|\r+\n", 0);
        }
        //----------------------------Erschaffung von "Patienten"----------------------------
        for (int i = 0; i < count; i++){
            patienten[i] = new Patient(i, namenArray[i], ((double)((int)(Math.random()*98+1))/10));
        }
        return patienten;
    }
    public void gibArrayAus( Patient[] array){
        System.out.println("++++++++++++++++++++++++++++++");
        System.out.println("Im Wartezimmer(Array) sitzen derzeit:");
        for (Patient patient : array) {
            if (patient != null) {
                System.out.println("PID: " + patient.getID() +
                        " PKrankheit: " + patient.getKrankheit() +
                        " pGrad: " + patient.getGrad());
            }
        }
        System.out.println("++++++++++++++++++++++++++++++"+"\n");
    }
    public boolean BinäreSuche(int ges, int o, int u, Patient[] a){
        int m = (int)(o+u)/2;
        if(ges == a[m].getID()){
            return true;
        }
        if((a[o].getID() > ges) ||(a[u].getID() < ges)){
            return false;
        }
        if(o == u){
            return false;
        }

        if(a[m].getID() > ges){
            return BinäreSuche(ges, o, m-1, a);
        }
        else{
            return BinäreSuche(ges, m+1, u, a);
        }

    }

    public void QuickSort(Patient[] a){
        getKleinstes(a, a[0].getGrad(), 0);

    }

    public double getKleinstes(Patient[] a, double kleinster,int i){
        if(a[i] == null && i >= 0){
            return kleinster;
        }
        if (a[i].getGrad() < kleinster) {
            return getKleinstes(a, a[i].getGrad(), i++);
        }
        return kleinster;
    }
    public static void main(String[] args) {
        Main eineMain = new Main(100);
        eineMain.gibArrayAus(eineMain.EinArray);
       System.out.println(eineMain.BinäreSuche(5, 0, eineMain.EinArray.length-1, eineMain.EinArray));
    }
}
