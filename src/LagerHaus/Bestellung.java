package LagerHaus;

import javax.lang.model.type.ArrayType;

public class Bestellung {
    private List<Artikel> Bestellung;
    //private Datum datum;

    Bestellung(List<Artikel> bestellung){
        Bestellung = bestellung;
    }

    public List<Artikel> getBestellung() {
        return Bestellung;
    }
}
