package DienstagsLinareSuche;

import Scooter.ComparableContent;

/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 18.05.2022
  * @author 
  */

public class Kunde implements ComparableContent<Kunde> {
  
  // Anfang Attribute
  private int Kundennummer;
  private String Vorname;
  private String Nachname;
  private String Nummernschild;
  // Ende Attribute
  
  public Kunde(int Kundennummer, String Vorname, String Nachname, String Nummernschild) {
    this.Kundennummer = Kundennummer;
    this.Vorname = Vorname;
    this.Nachname = Nachname;
    this.Nummernschild = Nummernschild;
  }

  // Anfang Methoden
  public int getKundennummer() {
    return Kundennummer;
  }

  public String getVorname() {
    return Vorname;
  }

  public String getNachname() {
    return Nachname;
  }

  public String getNummernschild() {
    return Nummernschild;
  }
  
  public boolean isEqual(Kunde pContent){
    return this.getKundennummer() == pContent.getKundennummer();
  }
  
  public boolean isGreater(Kunde pContent){
    return this.getKundennummer() > pContent.getKundennummer();
  }
  
  public boolean isLess (Kunde pContent){
    return this.getKundennummer() < pContent.getKundennummer();
  }

  // Ende Methoden
} // end of Kunde