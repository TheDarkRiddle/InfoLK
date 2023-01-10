package Sortieren;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Wartezimmer{

    Patient[] meineBubbleP;
    Patient[] meineShakerP;
    List<Patient> meinePListI;

    List<Patient> meinePListS;

    /**
     *   Eine Klasse zum speichern interessanter Daten
     * @swaps Die anzahl an Schritten in denen einn Object bewegt wird Objekten
     * @zyklen Die Anzal an durchläufen der Gesammten Struktur
     * @time Die zeit in sekunden die die Methode brauchte
     * @objToSort Die Sortierten Objecte
     */
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

    public Wartezimmer(int pI)    {
        meineBubbleP = new Patient[pI];
        meinePListI = new List<>();
        //public Patient(int pID, String pKrankheit, double pGrad)
        String krankheitenListe = "src/Sortieren/Krankheiten";
        meineBubbleP = makeKranke( pI, krankheitenListe);
        meineShakerP = makeKranke(pI, krankheitenListe);
        meinePListI = ArrayToList(meineBubbleP);
        meinePListS = ArrayToList(meineShakerP);
    }

    public void newPatient(Patient pPatient) {
        if(pPatient !=null) {
            meinePListI.append(pPatient);
            for(int i = 0; i< meineBubbleP.length; i++) {
                if(meineBubbleP[i] == null) {
                    meineBubbleP[i] = pPatient;
                    i = meineBubbleP.length;
                }
            }
        }
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

    public void gibListAus(List<Patient> list){
        System.out.println("++++++++++++++++++++++++++++++");
        System.out.println("Im Wartezimmer(List) sitzen derzeit:");
        list.toFirst();
        while(list.hasAccess()){
            Patient temp = list.getContent();
            System.out.println("PID: " + temp.getID()+
                    " PKrankheit: " + temp.getKrankheit()+
                    " pGrad: " + temp.getGrad());
            list.next();
        }
        System.out.println("++++++++++++++++++++++++++++++"+"\n");
    }

    private void swap (int i, int j, Patient[] array){
        if (i>=0&&j>=0&&i< array.length&&j< array.length){
            Patient temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

    private List<Patient>ArrayToList(Patient[] array){
        List<Patient> eineListe = new List<>();
        for (Patient patient : array) {
            eineListe.append(patient);
        }
        return eineListe;
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

    /**
    *   Ein Bubble sort
    *
    * @param metaData zur weitergabe der meta daten. Um später zu wissen wie lange die Methode gebraucht hat etc
     * @param toSort Array welches sortiert wird
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
                    swap(j, j+1, toSort);
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
    /**
     *   Ein Shaker sort
     *
     @param metaData zur weitergabe der meta daten. Um später zu wissen wie lange die Methode gebraucht hat etc.
     @param toSort Array welches sortiert wird
     */
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
                    swap(j, j+1, toSort);
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
                    swap(j, j+1, toSort);
                    swapped = true;
                    metaData.swaps++;
                }
            }
            //eine richtig links
            start++;
        }
        metaData.time = System.currentTimeMillis() - tempT;
    }

    /**
     *   Ein insertion sort
     *
     @param metaData zur weitergabe der meta daten. Um später zu wissen wie lange die Methode gebraucht hat etc.
     @param pListe Liste welche sortiert wird
     */
    public List<Patient> insertionSort(List<Patient> pListe, TempMetaData metaData){
        double tempT= System.currentTimeMillis();
        boolean sorted;
        List<Patient> sortiert = new List<>();

        pListe.toFirst();
        while (pListe.hasAccess()) {
            metaData.zyklen++;
            Patient temp = pListe.getContent();
            pListe.remove();
            //pListe.toFirst();
            //Sortierte Liste leer
            if (sortiert.isEmpty()) {
                sortiert.append(temp);
                metaData.swaps++;
            } else {
                //passende stelle finden
                sortiert.toFirst();
                sorted = false; // auf standart wert

                while (sortiert.hasAccess()) {
                    if ((temp.isGreater(sortiert.getContent()) || (temp.isEqual(sortiert.getContent())))) { //passend
                        sortiert.insert(temp);
                        sortiert.toLast(); // current auf last
                        sortiert.next(); // current auf null = schleife false
                        sorted = true;
                    }else { //nicht passend
                        sortiert.next();
                    }
                }

                if (!sorted){ // nichts passendes gefunden
                    sortiert.append(temp);
                    metaData.swaps++;
                }
            }
            //pListe.next();
            pListe.toFirst(); // für neuen durchlauf auf current auf first
        }

        metaData.time = System.currentTimeMillis() - tempT;
        return sortiert;
    }
    /**
     *   Ein Selection sort
     *
     @param metaData zur weitergabe der meta daten. Um später zu wissen wie lange die Methode gebraucht hat etc.
     @param pListe Liste welche sortiert wird
     */
    public List<Patient> selectionSort(List<Patient> pListe, TempMetaData metaData){
        double tempT= System.currentTimeMillis();
        List<Patient> sortiert = new List<>();

        pListe.toFirst();
        while (pListe.hasAccess()) {
            metaData.zyklen++;
            Patient temp = pListe.getContent();
            // kleinstes finden
            while (pListe.hasAccess()) {
                if (temp.isLess(pListe.getContent())){
                    temp = pListe.getContent();
                }
                pListe.next();
            }
            //zum entfernen des zufor als kleinstes gefundene obj aus der liste
            pListe.toFirst();
            while (temp != pListe.getContent()){
                pListe.next();
            }
            pListe.remove();

            metaData.swaps++;
            sortiert.append(temp);
            pListe.toFirst();
        }
        metaData.time = System.currentTimeMillis() - tempT;
        return sortiert;
    }
    public List<Patient> hendrik(List<Patient> pListe, TempMetaData metaData){
        double tempT= System.currentTimeMillis();

        List<Patient> temp = new List<Patient>();
        Patient lowestGrade = null;
        while(!pListe.isEmpty()){
            metaData.zyklen ++;
            pListe.toFirst(); //Zeile C
            lowestGrade=null; // Diese zeile kann gegen: " lowestGrade=pListe.getContent()" getauscht werden, dann wird "Block B"überfällig. So nimmst du zum Testen das erste, und das ess ein Neues ist ist ja auch noch gewährleistet
            while(pListe.hasAccess()){
                if(lowestGrade == null){                //
                    lowestGrade = pListe.getContent();  // Block B
                }                                       //
                if(lowestGrade.isLess(pListe.getContent())){ //Sucht das größte
                    lowestGrade = pListe.getContent();
                }
                pListe.next();
            }
            pListe.toFirst();
            //hier kann "Zeile A" hin, sie hat keinen Grund in der Schleife zu sein
            while(pListe.hasAccess()){
                if(lowestGrade==pListe.getContent()){
                    temp.append(pListe.getContent()); //Zeile A
                    pListe.remove();
                    pListe.toLast();// überfällig, da du in "Zeile C" auf den Ersten so oder so üpfst und deine Abbruch bedingung "IsEmpty"ist
                }
                //--->>> hier muss "DEINELISTE.next();" hin
            }
            pListe.next(); // überfällig, da du in "Zeile C" auf den Ersten so oder so üpfst und deine Abbruch bedingung "IsEmpty"ist. Du sprigst auf NULL-obj = kann gefährlich sein
        }
        metaData.time = System.currentTimeMillis() - tempT;
        return temp;
    }

    public static void main(String[] args) {
        double l = System.currentTimeMillis();
        int gewuenschte = 50000; //----Anzahl der Sortierten obj----
        Wartezimmer einZimmer = new Wartezimmer(gewuenschte);

        double round1 = System.currentTimeMillis()- l;
        //----Wähle den gefünschten algorythmus, in dem amn die entsptechenden zeilen ent-kommentiert, und alle nicht gewünschten "einZimmer.[AlgorythmussName]()" Zeilen auskommentiert
        //----Bubble----
        TempMetaData bubbleData = new TempMetaData();
        einZimmer.BubbleSort(bubbleData, einZimmer.meineBubbleP);
        einZimmer.gibArrayAus(einZimmer.meineBubbleP);

        //----Shaker----
        TempMetaData shakerData = new TempMetaData();
        //einZimmer.ShakerSort(shakerData, einZimmer.meineShakerP);
        //einZimmer.gibArrayAus(einZimmer.meineShakerP);

        //----Insertion----
        TempMetaData insertionData = new TempMetaData();
        //einZimmer.meinePListI = einZimmer.insertionSort(einZimmer.meinePListI, insertionData);
        //einZimmer.gibListAus(einZimmer.meinePListI);

        //----Selection----
        TempMetaData selectionData = new TempMetaData();
        //einZimmer.meinePListS = einZimmer.selectionSort(einZimmer.meinePListI, selectionData);
        //einZimmer.gibListAus(einZimmer.meinePListS);

        //-----Hendrik----
        TempMetaData hendrikData = new TempMetaData();
        //einZimmer.meinePListS = einZimmer.hendrik(einZimmer.meinePListS, hendrikData);
        //einZimmer.gibListAus(einZimmer.meinePListS);

        System.out.println("--------------------------------------------------------");
        System.out.println("Gesamte Prozess Dauer ≈ " + (System.currentTimeMillis()- l)/1000 + " (Sek)" );
        System.out.println("Erstellung des Zimmers und seinen Patienten ≈ " + round1/1000 + " (Sek)");
        System.out.println("---------------------------BUBBLE-----------------------------");
        bubbleData.toConsole();
        System.out.println("---------------------------SHAKER-----------------------------");
        shakerData.toConsole();
        System.out.println("---------------------------INSERTION-----------------------------");
        insertionData.toConsole();
        System.out.println("---------------------------SELECTION-----------------------------");
        selectionData.toConsole();
        System.out.println("--------------------------------------------------------");
        System.out.println("---------------------------Hendirk-----------------------------");
        hendrikData.toConsole();
    }
}
