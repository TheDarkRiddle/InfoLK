package Scooter;
public class Scooter implements ComparableContent<Scooter>
{
  int nummer; 
  int akkuladung; 
  Kunde ausleiher;
  Standort standort; 
  public Scooter(int pNummer){
   nummer = pNummer;      
  }
  public int gibNummer(){
   return this.nummer;
  }
  public int gibAkkuladung(){
   return this.akkuladung;
  }
  public boolean isEqual(Scooter pComparableContent){
   if(pComparableContent !=null){
    Scooter a = pComparableContent;
    if(this.gibNummer() == a.gibNummer()){
     return true;
    }
   }
   return false;
  }
  public boolean isGreater(Scooter pComparableContent){
   if(pComparableContent !=null){
    Scooter a = pComparableContent;
    if(this.gibNummer() > a.gibNummer()){
     return true;
    }
   }
   return false; 
  }
  public boolean isLess(Scooter pComparableContent){
   if(pComparableContent !=null){
    Scooter a = pComparableContent;
    if(this.gibNummer() < a.gibNummer()){
     return true;
    }
   }
   return false; 
  }
  public Kunde gibAusleiher(){
   return this.ausleiher;
  } 
  public Standort gibStandort(){
   return this.standort;
  }
  public void setzeStandort(Standort pStandort){
   if(pStandort != null){
    Standort stantort = pStandort; 
   }
  }
  public void setzeAkkuladung(int pAkkuladung){
   if(0<pAkkuladung && pAkkuladung<100){
   akkuladung = pAkkuladung;  
  }
  }
  public void setzeAusleiher(Kunde pAusleiher){
   if(pAusleiher != null){   
    ausleiher = pAusleiher; 
   }
  }
}
