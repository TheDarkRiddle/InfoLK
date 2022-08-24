package Metavers;

public class Main {

    private static Programm watsapp;
    private static Avatar avatar;
    private static Acount acount;
    private static MetaversMain metavers;
            
    public static void main(String[] args) {
        watsapp = new Programm("WatsApp");
        avatar = new Avatar("Peter", "Halli Hallo meine lieben Freunde");
        acount = new Acount(avatar,1);
        acount.addPrgramm(watsapp);
        Acount[] aAcounts = new Acount[1];
        aAcounts[0] = acount;
        metavers = new MetaversMain(aAcounts);
    }
}
