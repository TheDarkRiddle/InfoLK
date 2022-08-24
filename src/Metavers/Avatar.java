package Metavers;

public class Avatar {
    //Attribs
    private String name;
    private String begruesung;

    //Const
    public Avatar(String pname, String pbegruesung){
        name = pname;
        begruesung = pbegruesung;
    }

    //Getter
    public String getName() {
        return name;
    }

    public String getBegruesung() {
        return begruesung;
    }

    //Setter
    public void setBegruesung(String pbild) {
        this.begruesung = pbild;
    }

    public void setName(String pname) {
        this.name = pname;
    }
}
