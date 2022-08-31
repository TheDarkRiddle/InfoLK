package FakeBlockChain;

public class Block {
    //atribs
    private Block last;
    private int id;
    private int kontoNR;
    private int empfKontoNR;
    private float betrag;

    public Block(Block pLast, int pID, int pKontoNR, int pEmpfKontoNR, float pBetrag){
        last = pLast;
        id = pID;
        kontoNR = pKontoNR;
        empfKontoNR = pEmpfKontoNR;
        betrag = pBetrag;
    }

    public Block(int pID, int pKontoNR, int pEmpfKontoNR, float pBetrag){
        id = pID;
        kontoNR = pKontoNR;
        empfKontoNR = pEmpfKontoNR;
        betrag = pBetrag;
    }
    public int getID(){
        return this.id;
    }
    public int getKontoNR(){
        return this.kontoNR;
    }
    public int getEmpfKontoNR(){
        return this.empfKontoNR;
    }
    public float getBetrag(){
        return this.betrag;
    }

    public static void main(String[] args) {
        Block firstBlock;
        firstBlock = new Block(5,0,1,30.0f);
        Block secondBlock;
        secondBlock = new Block(firstBlock, 6,1,0,30.0f);


        System.out.println("Block lebt");
    }
}