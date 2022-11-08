package LagerHaus;

public class Artikel {
    private String Name;
    private float Preis;
    private int NR;

    Artikel(String name, float preis, int nr){
        Name = name;
        Preis = preis;
        NR = nr;
    }

    public String getName() {
        return Name;
    }

    public float getPreis() {
        return Preis;
    }

    public int getNR() {
        return NR;
    }
}
