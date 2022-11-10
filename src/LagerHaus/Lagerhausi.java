package LagerHaus;
import FakeBlockChain.Patient;
import FakeBlockChain.Stack;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Lagerhausi {
   private List<Artikel> Rest;
   private Stack<Artikel> ImLager;
   private static String LagerListe = "src/LagerHaus/Aritekels";

   Lagerhausi(Stack<Artikel> imLager){
       Rest = new List<Artikel>();
        ImLager = imLager;
   }
    /**
     * Erstellt einen Stack an produkten, welcher die Namen aus einer Liste enthält, einen zufälligen Preis zu weist,
     * und eine ID vergibt
     * @param count Die Menge an Artikeln die Generiert werden soll
     * @param adress Der Pfad, andem die Datei liegt aus der Gelese werden soll.
     *               Es wird eine Liste mit Wörtern erwartet, welche durch Zeilenumbrüche und Spaces getrennt sind.
     */
    public static Stack<Artikel> makeArticles(int count, String adress){
        //Ausgabe Stack
        Stack<Artikel> manyArticels= new Stack<Artikel>();
        //String in den die Namen geladen werden
        String names = null;
        //Versuch die Namen zu laden
        try {
            names = Files.readString(Path.of(adress));
        } catch (IOException e) {
            //Namen File nicht lesbar
            throw new RuntimeException(e);
        }
        //Aufteilung der Namen in ein Array
        //regex magie
        String[] namenArray = names.split("\\t|\\r+\\n",count);
        namenArray[count-1] = namenArray[count-1].replaceAll("\\b\\W+\\w*","");
        //Erschaffung von "Patienten"
        for (int i = 0; i < count; i++){
            manyArticels.push(new Artikel(namenArray[i], (float)(Math.random()*120)+1, i ));
        }
        return manyArticels;
    }
    /**
     * Erstellt eine Liste an produkten, welche die Namen aus einer Liste enthält, einen zufälligen Preis zu weist,
     * und eine ID vergibt
     * @param count Die Menge an Artikeln die Generiert werden soll
     * @param adress Der Pfad, andem die Datei liegt aus der Gelese werden soll.
     *               Es wird eine Liste mit Wörtern erwartet, welche durch Zeilenumbrüche und Spaces getrennt sind.
     */
    public static List<Artikel> makeArticlesAsList(int count, String adress){
        //Ausgabe Stack
        List<Artikel> manyArticels = new List<Artikel>();
        //String in den die Namen geladen werden
        String names = null;
        //Versuch die Namen zu laden
        try {
            names = Files.readString(Path.of(adress));
        } catch (IOException e) {
            //Namen File nicht lesbar
            throw new RuntimeException(e);
        }
        //Aufteilung der Namen in ein Array
        //regex magie
        String[] namenArray = names.split("\\t|\\r+\\n",count);
        namenArray[count-1] = namenArray[count-1].replaceAll("\\b\\W+\\w*","");
        //Erschaffung von "Patienten"
        for (int i = 0; i < count; i++){
            manyArticels.append(new Artikel(namenArray[i], (float)(Math.random()*120)+1, i ));
        }
        return manyArticels;
    }
  private void neueBestellung(Bestellung neueBestellung){
    if (canBeSend(neueBestellung.getBestellung())){
        System.out.println("Gesendet");
    }
    else{
        Rest.concat(neueBestellung.getBestellung());
    }
  }
    /**
     * Prüft ob ein ein Bestimmter Artikel anhand seiner NR im Lager Vorhanden ist
     * @param gesucht Ein Spezifischer Artikel
     */
  private boolean onHold(Artikel gesucht){
       Stack<Artikel> LagerListe = ImLager;
       while (!LagerListe.isEmpty()){
           if (LagerListe.top().getNR() == gesucht.getNR()){
               return true;
           }
           LagerListe.pop();
       }
       return false;
  }
    /**
     * Prüft ob eine Bestellung nur Artikelbeinhalet die im Lager vorhanden sind
     * @param bestellung Eine Liste, in der Klasse Bestellung, welche viele Artikel beinhaltet
     */
  private boolean canBeSend(List<Artikel> bestellung){
       bestellung.toFirst();
       while ( bestellung.hasAccess()){
            if (!(onHold(bestellung.getContent()))){
                return false;
            }
       }
       return true;
  }
    /**
     * Level 3
     * Prüft ob ein bestimmter Artikel in einer bestellung vorhanden ist, die Policei sieht es!
     * @param bestellung Eine Liste, in der Klasse Bestellung, welche viele Artikel beinhaltet
     */
  private Artikel getArtikelNROfExpensives(List<Artikel> bestellung){
      bestellung.toFirst();
      Artikel expensiv = bestellung.getContent();
      while ( bestellung.hasAccess()){
          if (bestellung.getContent().getPreis() < expensiv.getPreis()){
              expensiv = bestellung.getContent();
          }
      }
    return expensiv;
  }
    private int countList(List<Artikel> toCount){
        toCount.toFirst();
        int count = 0;
        while ( toCount.hasAccess()){
           count++;
        }
        return count;
    }
    private int countOver50(List<Artikel> toCount){
        toCount.toFirst();
        int count = 0;
        while ( toCount.hasAccess()){
            if (toCount.getContent().getPreis() > 50){
                count++;
            }
        }
        return count;
    }
    /**
     * Sucht nach Keksen und gibt sie dir, damit du sie essen kannst,
     * die Kekse werden ihrem Uhrsprung entfernt.
     * @param toCount Eine Liste, die die durchsucht werden soll
     */
    private List<Artikel> getAllKEKSE(List<Artikel> toCount){
        toCount.toFirst();
        List<Artikel> KEKSE = new List<Artikel>();
        while ( toCount.hasAccess()){
            if (toCount.getContent().getName().equalsIgnoreCase("Kekse")||
                    toCount.getContent().getName().equalsIgnoreCase("Keks")){
                KEKSE.append(toCount.getContent());
                toCount.remove();
            }
        }
        return KEKSE;
    }
    public static void main(String[] args) {

        Stack<Artikel> Lagerbestant = makeArticles(20, LagerListe);

        Lagerhausi AmazoneLager = new Lagerhausi(Lagerbestant);

        Bestellung ersteBestellung;
        List<Artikel> wuensche = makeArticlesAsList(3, LagerListe);
    }
}
