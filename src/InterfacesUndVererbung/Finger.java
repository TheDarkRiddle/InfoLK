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


    public static void main(String[] args) {
        Finger zeigeFinger = new Finger("Zeigefinger", "Linke");
        zeigeFinger.winken();
           System.out.println(zeigeFinger.ausgabe());


    }
}
