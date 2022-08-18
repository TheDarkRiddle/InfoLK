package Person;

public class Lehrer extends Person{

    //atribs
    private String kürzel;

    //__Methods__
    public Lehrer(){
        kürzel = "none";
        super();
    }

    /**
     * @param pKürzel Names Kürzel des Lehrer
     * @param pAlter Das Alter des Lehrer
     * @param pName  Name des Lehrer
     */
    public Lehrer(String pKürzel, int pAlter,String pName){
        super(pName, pAlter);
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
        return "Name:" + this.name + " Alter:" + this.alter + " Kürzel:" + this.kürzel;
    }
}