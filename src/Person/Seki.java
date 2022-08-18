package Person;

public class Seki extends Person{

    //atribs
    private int alter;
    private String name;
    private int teleNR;

    //__Methods__
    public Seki(){
        teleNR = 0;
        alter = 0;
        name = "none";
    }

    /**
     * @param pTeleNR Telefon NR des Seketeriates
     * @param pAlter Das Alter des Seketeriates
     * @param pName  Name des Seketeriates
     */
    public Seki(int pTeleNR, int pAlter,String pName){
        teleNR = pTeleNR;
        alter = pAlter;
        name = pName;

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
        return "Name:" + this.name + " Alter:" + this.alter + " Telefon Nummer:" + this.teleNR;
    }
}
