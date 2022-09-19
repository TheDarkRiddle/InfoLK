package FakeBlockChain;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class Schule {
    Stack<Patient> sMenschen;
    String pPatientNames = "src/FakeBlockChain/Names";

    Schule (){
        sMenschen = new Stack<Patient>();
    }

    private Stack<Patient> turnOver(Stack<Patient> sToTurn){
        Stack<Patient> sTemp = new Stack<Patient>();
        while(!sToTurn.isEmpty()){
            sTemp.push(sToTurn.top());
            sToTurn.pop();
        }
        return sTemp;
    }

    public Stack<Patient> makePeopel(int count){
        //Ausgabe Stack
        Stack<Patient> manyPeopel= new Stack<Patient>();
        //String in den die Namen geladen werden
        String namen = null;
        //Versuch die Namen zu laden
        try {
            namen = Files.readString(Path.of(pPatientNames));
        } catch (IOException e) {
            //Namen File nicht lesbar
            throw new RuntimeException(e);
        }
        //Aufteilung der Namen in ein Array
        String[] namenArray = namen.split("\\t|\\r+\\n",count);
        namenArray[count-1] = namenArray[count-1].replaceAll("\\b\\W+\\w*","");
        //Erschaffung von "Patienten"
        for (int i = 0; i < count; i++){
            manyPeopel.push(new Patient((int)(Math.random()*120)+1, namenArray[i]));
        }
        return manyPeopel;
    }

    public int count(){
        int count = 0;
        Stack<Patient> sTemp = new Stack<Patient>();

        while(!sMenschen.isEmpty()){
            sTemp.push(sMenschen.top());
            count++;
            sMenschen.pop();
        }
        sMenschen = turnOver(sTemp);
        return count;
    }

    public int countWith(int searchAlter){
        int count = 0;
        if(searchAlter >= 0){
            Stack<Patient> sTemp = new Stack<Patient>();

            while(!sMenschen.isEmpty()){
                sTemp.push(sMenschen.top());
                if(searchAlter == sMenschen.top().getAlter()){
                   count++;
                }
                sMenschen.pop();
            }
            sMenschen = turnOver(sTemp);
        }
        return count;
    }

    public Patient searchForPatient(String serachedFor){
        Patient tempP = new Patient(0,"NoPatientFound");
        if(serachedFor != null){
            Stack<Patient> sTemp = new Stack<Patient>();

            while(!sMenschen.isEmpty()){
                sTemp.push(sMenschen.top());
                if(serachedFor.equals(sMenschen.top().getName())){
                    tempP = sMenschen.top();
                }
                sMenschen.pop();
            }
            sMenschen = turnOver(sTemp);
        }
        return tempP;
    }

    public Stack<Patient> searchForPatienten(String serachedFor){
        Stack<Patient> sResult = new Stack<Patient>();
        if(serachedFor != null){
            Stack<Patient> sTemp = new Stack<Patient>();

            while(!sMenschen.isEmpty()){
                sTemp.push(sMenschen.top());
                if(serachedFor.equals(sMenschen.top().getName())){
                    sResult.push(sMenschen.top());
                }
                sMenschen.pop();
            }
            sMenschen = turnOver(sTemp);
        }
        return sResult;
    }

    public void showPatients(int count){
        Stack<Patient> sTemp = new Stack<Patient>();
        if (count == 0){
            count = this.count();
        }
        for (int i = 0; i < count; i++){
            sTemp.push(sMenschen.top());
            System.out.println("____Patient"+(i+1)+"____\n"+sMenschen.top().toString());
            sMenschen.pop();
        }
        sMenschen = turnOver(sTemp);
    }

    public static void main(String[] args) {
        Schule eineSchule = new Schule();
        Schule zweiSchule = new Schule();
        Patient one = new Patient(1, "Gert");
        Patient two = new Patient(10, "Gert");
        Patient tree = new Patient(10, "Susi");
        Patient four = new Patient(1, "Heidi");
        Patient five = new Patient(20, "Frank");
        Patient six = new Patient(33, "Renee");

        eineSchule.sMenschen.push(one);
        eineSchule.sMenschen.push(two);
        eineSchule.sMenschen.push(tree);
        eineSchule.sMenschen.push(four);
        eineSchule.sMenschen.push(five);
        eineSchule.sMenschen.push(six);


        zweiSchule.sMenschen = zweiSchule.makePeopel(10);
        zweiSchule.showPatients(10);
        System.out.println("Zwei Schule:" + zweiSchule.count());
        System.out.println("\n Patient Namesns Heidi: " + eineSchule.searchForPatient("Heidi").getName());
    }
}
