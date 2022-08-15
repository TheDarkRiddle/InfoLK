package UML_HA;

public class Haus {
    //atributes
    private String farbe;
    private int baujahr;
    private int groesse;

    //functions
    public Haus(){
        farbe = "Default";
        baujahr = 0;
        groesse = 0;
    }

    public Haus(String farbe, int baujahr, int groesse){
        this.farbe = farbe;
        this.baujahr = baujahr;
        this.groesse = groesse;
    }


    //Getter
    public int getGroesse() {
        return groesse;
    }

    //Setter
    public void setFarbe(String farbe) {
        this.farbe = farbe;
    }
    public void setBaujahr(int baujahr) {
        this.baujahr = baujahr;
    }
}
