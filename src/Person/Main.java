package Person;

public class Main {

    private static Schüler Peter = new Schüler(5,2005,"Peter");
    private static Lehrer Lisa = new Lehrer("LW", 1990, "Lisa");
    private static Seki Gert = new Seki(02261, 1988, "Gert");
    
    public static void main(String[] args) {
        System.out.println(Peter.toString());
        System.out.println(Lisa.toString());
        System.out.println(Gert.toString());
    }
}
