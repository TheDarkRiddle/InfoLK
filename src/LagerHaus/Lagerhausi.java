package LagerHaus;
import FakeBlockChain.Stack;

public class Lagerhausi {
   private List<Artikel> Rest;
   private Stack<Artikel> ImLager;

   Lagerhausi(Stack<Artikel> imLager){
       Rest = new List<Artikel>();
        ImLager = imLager;
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

    public static void main(String[] args) {
      List<Artikel> lieverListe;
        Lagerhausi AmazoneLager;

    }
}
