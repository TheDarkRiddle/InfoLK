package Scooter;


import LagerHaus.List;
import Sortieren.Patient;

public class ScooterVerwaltung
{
    List<Kunde>alleKunden = new List<Kunde>();
    BinarySearchTree<Scooter>alleScooter= new BinarySearchTree<Scooter>();
    public ScooterVerwaltung(){}

    public Scooter gibScooter(int pNummer){
        if (pNummer < 0){
            return null;
        }
        return alleScooter.search(new Scooter(pNummer));
    }
    public List<Scooter> ermittleEtwas(List<Scooter>pScooterSammlung){
     Standort ort= new Standort(0,0); 
     List<Scooter> ergebnis = new List<Scooter>(); 
     while(!pScooterSammlung.isEmpty()){
      pScooterSammlung.toFirst();
      Scooter naechster = pScooterSammlung.getContent(); 
      pScooterSammlung.next();
      while(pScooterSammlung.hasAccess()){
       Scooter test= pScooterSammlung.getContent();
       if(ort.liefereDistanz(test.gibStandort())
       <ort.liefereDistanz(naechster.gibStandort())){
        naechster = test; 
       }
       pScooterSammlung.next();
      }
      pScooterSammlung.toFirst();
      while(pScooterSammlung.getContent() != naechster){
       pScooterSammlung.next();
      }
      pScooterSammlung.remove(); 
      ergebnis.append(naechster);
      ort=naechster.gibStandort();
     }
     return ergebnis;
    }

    /**
     * Ermittelt alle Scooter die zu weit von der Zentrale am P(0/0) stehehn
     * @param pDistanz die Distanz die die Scooter max. von der Zentrale entfernt stehen dürfen
     * **/
    List<Kunde> ermittleWarnListe(int pDistanz){
        List<Kunde> erg = new List<Kunde>();
        if (pDistanz <= 0){
            return erg;
        }
        //Falschparker werden ermittelt
        gibFalschParker(alleScooter, erg, pDistanz);
        //Strafzettel können verteilt werden
        return erg;
    }
    /**
     * Simple methode die einen BST nur durchläuft, und Scooter in einer Liste speichert, die
     * weiter weg stehen als pDistanz.
     * @param pDistanz die Distanz ab der ein Scooter als zu weit weg gilt(einen drüber).
     * @param liste Die mit zu übergebene Liste, in die die Scooter gespeichert werden.
     * @param tree der BTS der durchlaufen werden soll.
     * */
    private void gibFalschParker(BinarySearchTree<Scooter> tree, List<Kunde> liste, int pDistanz){
        if (tree.isEmpty() || alleScooter.isEmpty()){
            return;
        }/*Firmen Zentrale ist definiert am P(0/0)*/
        if (tree.getContent().gibStandort().liefereDistanz(new Standort(0,0)) >
                pDistanz && tree.getContent().gibAusleiher()!=null){
            liste.append(tree.getContent().gibAusleiher());
        }
        gibFalschParker(tree.getRightTree(), liste, pDistanz);
        gibFalschParker(tree.getLeftTree(), liste, pDistanz);
    }
    public void gibListAus(List<Kunde> list){
        System.out.println("++++++++++++++++++++++++++++++");
        System.out.println("Scooter" + ":");
        list.toFirst();
        while(list.hasAccess()){
            Kunde temp = list.getContent();
            System.out.println("Kunde: " + temp.gibEMailAdresse());
            list.next();
        }
        System.out.println("++++++++++++++++++++++++++++++"+"\n");
    }
    public static void main(String[] args) {
        Scooter b = new Scooter(10);
        b.setzeAusleiher(new Kunde("Frank","21"));
        b.standort = new Standort(22,22);
        Scooter f = new Scooter(14);
        f.setzeAusleiher(new Kunde("Reiner","21"));
        f.standort = new Standort(2,2);
        Scooter n = new Scooter(17);
        n.standort = new Standort(100,100);
        ScooterVerwaltung a = new ScooterVerwaltung();
        a.alleScooter.insert(b);
        a.alleScooter.insert(b);
        a.alleScooter.insert(b);
        a.alleScooter.insert(f);
        a.alleScooter.insert(n);
        List c = a.ermittleWarnListe(10);
        a.gibListAus(c);

    }
}
