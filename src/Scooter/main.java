package Scooter; // nicht zu beachten

import Ahnenbaum.BinaryTree;
import LagerHaus.List;
import javax.naming.ldap.LdapReferralException;
/*Die imports müssen je nach umgebung angepasst werden
* nicht zu vergessen sind die Imports für:
* Kunde
* Scooter
* Standort
*/
/*
public class main {

    //List<Kunde> ermittletwas(int pDistanz);
    //Dekli. ini. der ergebniss liste
    //parameter check + dekl. ini. der Ausgabe Liste
    //return Lerre Liste wenn es keine Kunden gibt oder der pDistanze negetiv/null/0 ist
    //baum durchlaufen ANFANG
    //  Prüfen ob Scooter ausgeliehen ist? JA: mache weiter NEIN: Nächster Scooter
    //Prüfe ob scooter zu weit weg ist? JA: append an Ergebnis liste. NEIN: Nächster Scooter
    //durch laufen ende
    //Return Liste wenn die kunden liste einmal geprüft wurde


    List<Kunde> ermittleWarnListe( int pDistanz){
        List<Kunde> erg = new List<Kunde>();
        if (pDistanz <= 0 || alleKunden.isEmpty()){
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
   /* void gibFalschParker(BinaryTree<Scooter> tree, List<Scooter> liste, int pDistanz){
        if (tree.isEmpty()){
         return;
        }/*Firmen Zentrale ist definiert am P(0/0)
        if (tree.getContent().gibStandort().liefereDistanz(new Standort(0,0)) >
                                                         pDistanz && tree.getContent().gibAusleiher()!=null){
            liste.append(tree.getContent());
        }
         gibFalschParker(tree.getRightTree(), liste, pDistanz);
         gibFalschParker(tree.getLeftTree(), liste, pDistanz);
    }
}
*/