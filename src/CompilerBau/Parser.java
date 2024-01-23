package CompilerBau;

public class Parser {

    public void Parser(){};
    //Listen die die Gramatik optionen darstellen
    private List<String> S = new List<String>();


    public boolean Parse(List<String> L)
    {
        //Check Reihenfolge der Tokens
        //Liste durchlaufen bis leer
        //Tokens checken mit IstInG
        // 0=S 1=A 2=S
        /*
        * Grammatik
        * S-> ZahlA | OperatorB
        * A-> OperatorB | ZahlB
        * B->Zahl
        * */
        L.toFirst();
        while (L.hasAccess())
        {
            String tempT = L.getContent();
        };
        return false;
    };

    public int IstInS(String Token)
    {
        //Prüfen ob das Token wählbar sein
    };
}