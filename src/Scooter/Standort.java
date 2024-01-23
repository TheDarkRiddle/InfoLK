package Scooter;
public class Standort
{
    int x;
    int y;
    public Standort(int pX, int pY){ 
     x=pX;
     y=pY;
    }
    public int liefereDistanz(Standort pOrt){
     if(pOrt != null){
      int Distanz; 
      Standort a= pOrt;
      Distanz=(int)(Math.round(Math.sqrt(Math.pow(this.x-a.gibX(),2)+Math.pow(this.y-a.gibY(),2))));
      return Distanz;
     }else{
      return 0;  
     }
    }
    public int gibX(){
     return this.x;
    }
    public int gibY(){
     return this.y;
    }
    }

