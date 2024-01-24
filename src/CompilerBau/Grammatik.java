    package CompilerBau;

    import java.util.HashMap;

    /**
     * Presents a grammatic with all of its productions
     * */
    public class Grammatik {

        public final HashMap<String, Character> S;
        public final HashMap<String, Character> A;
        public final HashMap<String, Character> B;
        public final HashMap<String, Character> AllProduktions;


       public Grammatik()
       {

           /*
            * Grammatik:
            * S-> ZahlA | OperatorB
            * A-> OperatorB | ZahlB
            * B->Zahl
            */
           S = new HashMap<>();
           S.put("ZahlA", 'A');
           S.put("OperatorB",'B');

           A = new HashMap<>();
           A.put("OperatorB",'B');
           A.put("ZahlB",'B');

           B = new HashMap<>();
           B.put("Zahl",' ');

           AllProduktions = new HashMap<>();
           AllProduktions.put("ZahlA", 'A');
           AllProduktions.put("OperatorB",'B');
           AllProduktions.put("ZahlB",'B');
           AllProduktions.put("Zahl",' ');
       }
    }