package FakeBlockChain;
public class Block {

    //Nummer
    private int n;
    //Daten
    private int id,betrag,sender,empfänger;
    private Block preBlock;

    public Block(int pID, int pBetrag, int pSender, int pEmpfänger) {
        id = pID;
        betrag = pBetrag;
        sender = pSender;
        empfänger = pEmpfänger;
    }

    public static void main(String[] args){}

    public int getId() {
        return id;
    }

    public int getBetrag() {
        return betrag;
    }

    public int getSender() {
        return sender;
    }

    public int getEmpfänger() {
        return empfänger;
    }

    public Block getPreBlock() {
        return preBlock;
    }


}