package Scooter;
public class Kunde
{
    String eMailAdresse;
    String kreditkartennummer;
    public Kunde(String pEMailAdresse, String pKreditkartennummer){
     eMailAdresse = pEMailAdresse;
     kreditkartennummer = pKreditkartennummer;
    }
    public String gibEMailAdresse(){
     return this.eMailAdresse;
    }
    public void setEMailAdresse(String peMailadresse){
     eMailAdresse=peMailadresse;
    }
    public String gibKreditkartennummer(){
     return this.kreditkartennummer;
    }
}
