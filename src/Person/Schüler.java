package Person;

public class Schüler extends Person{
    
    //atribs
    private int klassenStufe;

    //__Methods__
    /**
     * @param pKS Klassenstufe des Schühlers
     * @param pAlter Das Alter des Schühlers
     * @param pName  Name des Schühlers
     */
    public Schüler(int pKS, int pAlter, String pName){
        super(pAlter, pName);
        klassenStufe = pKS;
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
    public int getKlassenStufe(){return klassenStufe;}

    //Setter
    @Override
    public void setName(String pName) {
       super.setName(pName);
    }
    public void setKlassenStufe(int pKS){klassenStufe = pKS;}

    //Other
    @Override
    public String toString() {
        return "Name:" + this.getName() + " Alter:" + this.getAlter() + " Klassenstufe:" + this.klassenStufe;
    }
}
