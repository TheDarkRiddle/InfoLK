package Sortieren;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Wartezimmer{

    Patient[] meineBubbleP;
    Patient[] meineShakerP;
    List<Patient> meinePList;

    static class TempMetaData {
        int swaps = 0;
        int zyklen = 0;
        double time = 0.0;
        int objToSort = 0;
        public void toConsole(){
            System.out.println("Sortierte Objeckte: " + objToSort + " Sortier Zyklen: " + zyklen + " Swaps: " + swaps);
            System.out.println("Sortierung des Zimmers und seinen Patienten ≈ " + time/1000 + " (Sek)");
        }
    }
    private static String KrankheitenListe = "src/Sortieren/Krankheiten";
    public Wartezimmer(int pI)    {
        meineBubbleP = new Patient[pI];
        meinePList = new List <Patient>();
        //public Patient(int pID, String pKrankheit, double pGrad)
        meineBubbleP = makeKranke( pI,KrankheitenListe);
        meineShakerP = makeKranke(pI, KrankheitenListe);
            //meinePList.append(p); TODO ArrayToList
    }

    public void newPatient(Patient pPatient) {
        if(pPatient !=null) {
            meinePList.append(pPatient);
            for(int i = 0; i< meineBubbleP.length; i++) {
                if(meineBubbleP[i] == null) {
                    meineBubbleP[i] = pPatient;
                    i = meineBubbleP.length;
                }
            }
        }
    }

    public void gibArrayAus(){
        System.out.println("++++++++++++++++++++++++++++++");
        System.out.println("Im Wartezimmer(Array) sitzen derzeit:");
        for(int i = 0; i< meineBubbleP.length; i++) {
            if(meineBubbleP[i] != null) {
                System.out.println("PID: " + meineBubbleP[i].getID()+
                        " PKrankheit: " + meineBubbleP[i].getKrankheit()+
                        " pGrad: " + meineBubbleP[i].getGrad());
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
        if (i>=0&&j>=0&&i< meineBubbleP.length&&j< meineBubbleP.length){
            Patient temp = meineBubbleP[i];
            meineBubbleP[i] = meineBubbleP[j];
            meineBubbleP[j] = temp;
        }
    }

    public static Patient[] makeKranke(int count, String adress){
        //Ausgabe DS
        Patient[] patienten = new Patient[count];
        //String in den die Namen geladen werden
        StringBuilder krankheiten = null;
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
            namenArray = krankheiten.append(temp).toString().split("\\t|\\r+\\n", 0);
        }
        //----------------------------Erschaffung von "Patienten"----------------------------
        for (int i = 0; i < count; i++){
            patienten[i] = new Patient(i, namenArray[i], ((double)((int)(Math.random()*98+1))/10));
        }
        return patienten;
    }

    /**
    *   Ein Bubble sort
    *
    @param metaData //zur weitergabe der meta daten.
     */
    public void BubbleSort(TempMetaData metaData , Patient[] toSort){
        double tempT = System.currentTimeMillis();
        int n = toSort.length;
        metaData.objToSort = n;

        for (int i = 0; i < n-1; i++){
            metaData.zyklen++;
            boolean swapped = false;
            for (int j = 0; j < n-i-1; j++){
                if (toSort[j].isGreater(toSort[j+1])){
                    swap(j, j+1);
                    swapped = true;
                    metaData.swaps++;
                }
            }
            if (!swapped){
                i = toSort.length;
            }
        }
        metaData.time = System.currentTimeMillis() - tempT;
    }
    public void ShakerSort(TempMetaData metaData, Patient[] toSort){
        double tempT = System.currentTimeMillis();
        int end = toSort.length;
        int start = 0;
        metaData.objToSort = end;
        boolean swapped = true;
        while (swapped){
            metaData.zyklen++;
            //bereiten für hin weg
            swapped = false;
            //----Hinweg----
            for (int j = start; j < end-1; j++){
                if (toSort[j].isGreater(toSort[j+1])){
                    swap(j, j+1);
                    swapped = true;
                    metaData.swaps++;
                }
            }
            //abruch?
            if (!swapped){
                break;
            }
            //anpassen für den rück weg
            swapped = false;
            //eine richting rechts
            end--;
            //----Rückweg----
            for (int j = end - 1; j >= start; j--){
                if (toSort[j].isGreater(toSort[j+1])){
                    swap(j, j+1);
                    swapped = true;
                    metaData.swaps++;
                }
            }
            //eine richtig links
            start++;
        }
        metaData.time = System.currentTimeMillis() - tempT;
    }

    public static void main(String[] args) {
        double l = System.currentTimeMillis();
        int gewuenschte = 300;
        Wartezimmer einZimmer = new Wartezimmer(gewuenschte);

        double round1 = System.currentTimeMillis()- l;
        //Bubble
        TempMetaData bubbleData = new TempMetaData();
        einZimmer.BubbleSort(bubbleData, einZimmer.meineBubbleP);
        einZimmer.gibArrayAus();

        //Shaker
        TempMetaData shakerData = new TempMetaData();
        einZimmer.ShakerSort(shakerData, einZimmer.meineShakerP);

        System.out.println("--------------------------------------------------------");
        System.out.println("Gesamte Prozess Dauer ≈ " + (System.currentTimeMillis()- l)/1000 + " (Sek)" );
        System.out.println("Erstellung des Zimmers und seinen Patienten ≈ " + round1/1000 + " (Sek)");
        System.out.println("---------------------------BUBBLE-----------------------------");
        bubbleData.toConsole();
        System.out.println("---------------------------SHAKER-----------------------------");
        shakerData.toConsole();
        System.out.println("--------------------------------------------------------");
    }
}