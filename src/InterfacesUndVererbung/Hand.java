package InterfacesUndVererbung;

public abstract class Hand {
    private String HandSeite;
    public Hand(String pHandSeite){
        HandSeite = pHandSeite;
    }
    private String handSeite;
    abstract public void winken();
    public String getHandSeite(){return HandSeite;};
}
