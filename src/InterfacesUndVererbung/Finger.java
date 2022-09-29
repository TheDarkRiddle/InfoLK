package InterfacesUndVererbung;

import FakeBlockChain.Patient;
import FakeBlockChain.Stack;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Finger extends Hand implements GebeAus {
   private String Name;
   Stack<Finger> sMenschen = new Stack<Finger>();
   String fingerPaths = "src/InterfacesUndVererbung/FingerNames";


   public Finger(String pName, String seite){
       super(seite);
       Name = pName;
   }
    @Override
    public void winken() {
        System.out.println("----------------------------");
        System.out.println(this.Name +"Winkt");
    }

    public String ausgabe(){
       return ("Ich bin der" + this.Name + "Ich bin an der" + super.getHandSeite());
    }

    public Stack<Patient> makePeopel(int count){
        //Ausgabe Stack
        Stack<Patient> manyPeopel= new Stack<Patient>();
        //String in den die Namen geladen werden
        String namen = null;
        //Versuch die Namen zu laden
        try {
            namen = Files.readString(Path.of(fingerPaths));
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
        Finger zeigeFinger = new Finger("Zeigefinger", "Linke");
        zeigeFinger.winken();
           System.out.println(zeigeFinger.ausgabe());


    }
}
