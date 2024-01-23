package CompilerBau;

public class Parser {

    //Attribute
    //Listen die die Gramatik optionen darstellen
    private static Grammatik MGrammatik;


    public Parser(Grammatik pG)
    {
        MGrammatik = pG;
    }

    /**
     * Prüft ob eine Token liste Gültig ist.
     *
     * @param L Zu pruefende Token Liste
     * */
    public boolean Parse(List<String> L)
    {
        L.toFirst();
        if (!L.hasAccess()) return false;
        L.toFirst();
        if (!SindTokenGueltig(L)) return false;
        L.toFirst();
        return IstInGrammatik(L, 'S');
    }

    /**
     * Prüft ob alle Tokens der Liste auch in der Grammatik vorhanden sind
     *
     * @param L Zu pruefende Token Liste
     * */
    public boolean SindTokenGueltig(List<String> L)
    {
        while (L.hasAccess())
        {
            if (!MGrammatik.AllProduktions.containsKey(L.getContent())) return false;
            L.next();
        }
        return true;
    }
    /**
     * Prüft ob die Reihenfolge der Tokens mit der Grammatik konstruierbar ist
     *
     * @param TL Eine Liste an Tokens, welche anhand der Grammatik Geprüft werden soll
     * @param PreviousChar Das Aktuelle Non-Terminal der Grammatik
     * */
    public boolean IstInGrammatik(List<String> TL, char PreviousChar)
    {
        //

        String Token = TL.getContent();
        Character NextChar;
        switch (PreviousChar)
        {
           case 'S':
               if (MGrammatik.S.containsKey(Token))
               {
                   System.out.print(PreviousChar+"->");

                   NextChar = MGrammatik.S.get(Token);
                   TL.next();
                   return IstInGrammatik(TL,NextChar);
               }else
               {
                   System.out.print("Error->");
                   return false;
               }
           case 'A':
               if (MGrammatik.A.containsKey(Token))
               {
                   System.out.print(PreviousChar+"->");

                   NextChar = MGrammatik.A.get(Token);
                   TL.next();
                   return IstInGrammatik(TL,NextChar);
               }else
               {
                   System.out.print("Error->");
                   return false;
               }
           case 'B':
               if (MGrammatik.B.containsKey(Token))
               {
                   System.out.print(PreviousChar+"->");

                   NextChar = MGrammatik.B.get(Token);
                   TL.next();
                   return IstInGrammatik(TL,NextChar);
               }else
               {
                   System.out.print("Error->");
                   return false;
               }
           case ' ':
               return !TL.hasAccess();
            default:
              return false;
       }
    }

    public static void main(String[] args) {
        Grammatik EineGrammatik = new Grammatik();
        Parser EinParser = new Parser(EineGrammatik);
        List<String> EineTokenListe = new List<>();

        EineTokenListe.append("ZahlA");
        EineTokenListe.append("ZahlB");
        EineTokenListe.append("Zahl");
        System.out.println("\n----------------------------------------------");
        System.out.println("Token Liste Gültig bis: ");
        System.out.println(" "+EinParser.Parse(EineTokenListe));


    }
}