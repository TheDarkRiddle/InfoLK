package CompilerBau;

public class Scanner {
    private List<String> TokenListe;
    public Scanner(String Satzt)
    {
        TokenListe = new List<>();
        SchneiderUndWeber(Satzt);
    }

    private String ScannWord(String Wort)
    {
        int Zustand = 0;
        for (int i = 0; i < Wort.length();i++)
        {
            switch (Zustand)
            {
                case 0:
                    if (Wort.charAt(i) == '1') Zustand = 4;
                    if (Wort.charAt(i) == '-') Zustand = 1;
                    if (Wort.charAt(i) == '+') Zustand = 2;
                    break;
                case 1:
                    if (Wort.charAt(i) == '-') Zustand = 3;
                    if (Wort.charAt(i) == '1' || Wort.charAt(i) == '0') return "Noken";
                    break;
                case 2:
                    if (Wort.charAt(i) == '+') Zustand = 3;
                    if (Wort.charAt(i) == '1' || Wort.charAt(i) == '0') return "Noken";
                    break;
                case 3:
                    if (Wort.charAt(i) == ' ') return "Operator";
                    if (Wort.charAt(i) == '1' || Wort.charAt(i) == '0') return "Noken";
                    break;
                case 4:
                    if (Wort.charAt(i) == ' ') return "Zahl";
                    if (Wort.charAt(i) == '-' || Wort.charAt(i) == '+') return "Noken";
                    break;
            }
        }
        return "FatalError";
    }
    private void SchneiderUndWeber(String Satzt)
    {
        if (Satzt == null || Satzt.length() == 0) return;
        int WortAnfang = 0;
        for (int i = 0; i < Satzt.length(); i++)
        {
            if (Satzt.charAt(i) == ' ')
            {
                TokenListe.append(ScannWord(Satzt.substring(WortAnfang, i)));
                WortAnfang = i+1;
            }
        }

    }

    public List<String> GetTokenListe(){ return TokenListe;}

    public static void main(String[] args) {
        String EinSatz = "1 + 101001";
        Scanner EinScanner = new Scanner(EinSatz);
        List<String> TokenList = EinScanner.GetTokenListe();
        TokenList.toFirst();
        System.out.println("\n Token Liste:\n");
        while (TokenList.hasAccess())
        {
            System.out.println(" "+TokenList.getContent());
            TokenList.next();
        }
    }
}