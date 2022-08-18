package Person;

public class Schüler extends Person{
    
    //atribs
    private int alter;
    private String name;
    private int klassenStufe;

    //__Methods__
    public Schüler(){
        klassenStufe = 0;
        alter = 0;
        name = "none";
    }

    /**
     * @param pKS Klassenstufe des Schühlers
     * @param pAlter Das Alter des Schühlers
     * @param pName  Name des Schühlers
     */
    public Schüler(int pKS, int pAlter, String pName){
        klassenStufe = pKS;
        alter = pAlter;
        name = pName;

    }
    //Getter
    @Override
    public int getAlter() {
        return alter;
    }

    @Override
    public String getName() {
        return name;
    }
    public int getKlassenStufe(){return klassenStufe;}

    //Setter
    @Override
    public void setName(String pName) {
        name = pName;
    }
    public void setKlassenStufe(int pKS){klassenStufe = pKS;}

    //Other
    @Override
    public String toString() {
        return "Name:" + this.name + " Alter:" + this.alter + " Klassenstufe:" + this.klassenStufe;
    }
}
