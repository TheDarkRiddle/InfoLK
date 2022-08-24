package Person;

public class Seki extends Person{

    //atribs
    private int teleNR;

    //__Methods__
    /**
     * @param pTeleNR Telefon NR des Seketeriates
     * @param pAlter Das Alter des Seketeriates
     * @param pName  Name des Seketeriates
     */
    public Seki(int pTeleNR, int pAlter,String pName){
        super(pAlter, pName);
        teleNR = pTeleNR;
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
    public int getTeleNR(){return teleNR;}

    //Setter
    @Override
    public void setName(String pName) {
        super.setName(pName);
    }
    public void setTeleNR(int pTeleNR){teleNR = pTeleNR;}

    //Other
    @Override
    public String toString() {
        return super.toString()+ " Telefon Nummer:" + this.teleNR;
    }
}
