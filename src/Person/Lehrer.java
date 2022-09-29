package Person;

public class Lehrer extends Person{

    //atribs
    private String kürzel;

    //__Methods__
    /**
     * @param pKürzel FingerNames Kürzel des Lehrer
     * @param pAlter Das Alter des Lehrer
     * @param pName  Name des Lehrer
     */
    public Lehrer(String pKürzel, int pAlter,String pName){
        super(pAlter, pName);
        kürzel = pKürzel;

    }
    //Getter
    @Override
    public int getAlter() {
        return super.getAlter();
    }

    @Override
    public String getName() {
        return super.getName();
    }
    public String getkürzel(){return kürzel;}

    //Setter
    @Override
    public void setName(String pName) {
        super.setName(pName);
    }
    public void setkürzel(String pKürzel){kürzel = pKürzel;}

    //Other
    @Override
    public String toString() {
        return "Name:" + this.getName() + " Alter:" + this.getAlter() + " Kürzel:" + this.kürzel;
    }
}
