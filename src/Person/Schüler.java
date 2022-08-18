package Person;

public class Schüler extends Person{
    
    //atribs
    private int klassenStufe;

    //__Methods__
    public Schüler(){
        klassenStufe = 0;
        super();
    }

    /**
     * @param pKS Klassenstufe des Schühlers
     * @param pAlter Das Alter des Schühlers
     * @param pName  Name des Schühlers
     */
    public Schüler(int pKS, int pAlter, String pName){
        klassenStufe = pKS;
        super(pAlter, pName);

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
        name = super.setName(pName);
    }
    public void setKlassenStufe(int pKS){klassenStufe = pKS;}

    //Other
    @Override
    public String toString() {
        return "Name:" + this.name + " Alter:" + this.alter + " Klassenstufe:" + this.klassenStufe;
    }
}
