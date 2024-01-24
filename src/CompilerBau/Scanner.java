package CompilerBau;

public class Scanner {
    private List<String> TokenListe;
    public Scanner(String Satz)
    {
        TokenListe = new List<>();
        SchneiderUndWeber(Satz);
    }

    private String ScannWord(String Wort)
    {
        int Zustand = 0;
        for (int i = 0; i <= Wort.length();i++)
        {
            switch (Zustand)
            {
                case 0:
                    if (Wort.charAt(i) == '1') Zustand = 4;
                    else if (Wort.charAt(i) == '-') Zustand = 1;
                    else if (Wort.charAt(i) == '+') Zustand = 2;
                    else return "Noken";
                    break;
                case 1:
                    if (Wort.charAt(i) == '-') Zustand = 3;
                    else if (Wort.charAt(i) == '1' || Wort.charAt(i) == '0') return "Noken";
                    break;
                case 2:
                    if (Wort.charAt(i) == '+') Zustand = 3;
                    else return "Noken";
                    break;
                case 3:
                    if (Wort.charAt(i) == ' ') return "Operator";
                    else return "Noken";
                case 4:
                    if (Wort.charAt(i) == ' ') return "Zahl";
                    else if (Wort.charAt(i) == '1' || Wort.charAt(i) == '0') break;
                    else return "Noken";
            }
        }
        return "FatalError";
    }
    private void SchneiderUndWeber(String Satz)
    {
        if (Satz == null || Satz.isEmpty()) return;
        if (Satz.charAt(Satz.length()-1) != ' ' ) Satz += " ";
        if (Satz.charAt(0) == ' ') Satz = Satz.substring(1);
        int WortAnfang = 0;
        for (int i = 0; i < Satz.length(); i++)
        {
            if (Satz.charAt(i) == ' ')
            {
                TokenListe.append(ScannWord(Satz.substring(WortAnfang, i)+" "));
                WortAnfang = i+1;
            }
        }

    }

    public List<String> GetTokenListe(){ return TokenListe;}

    public static void main(String[] args) {
        String EinSatz = " 10 ++ 10101";
        Scanner EinScanner = new Scanner(EinSatz);
        List<String> TokenList = EinScanner.GetTokenListe();
        TokenList.toFirst();
        System.out.println("\n Token Liste:");
        while (TokenList.hasAccess())
        {
            System.out.print(" "+TokenList.getContent());
            TokenList.next();
        }
    }
}