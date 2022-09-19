package FakeBlockChain;

public class KrankenHaus {
    static Queue<Block> QKranken;

    public KrankenHaus(){
        QKranken = new Queue<Block>();
    }

    public void addBlock(Block value){
       if(value != null){
           QKranken.enqueue(value);
       }
    }
    public void deletBlock(){
        QKranken.dequeue();
    }
    /*Template
     Queue<Block> tempQ = new Queue<Block>();
       while(!QKranken.isEmpty()){
           tempQ.enqueue(QKranken.front());
           QKranken.dequeue();
       }
       QKranken = tempQ;
    */
    public int countQ(){
        int count = 0;
        Queue<Block> tempQ = new Queue<Block>();
        while(!QKranken.isEmpty()){

            tempQ.enqueue(QKranken.front());
            count++;
            QKranken.dequeue();
        }
        QKranken = tempQ;
        return count;
    }

    public int countTransaktionOverX(int X){
        int count = 0;
        if (!(X <= 0)){
            Queue<Block> tempQ = new Queue<Block>();
            while(!QKranken.isEmpty()){
                tempQ.enqueue(QKranken.front());
                if (QKranken.front().getBetrag() >100){
                    count++;
                }
                QKranken.dequeue();
            }
            QKranken = tempQ;
        }
        return count;
    }

    public String getDataFromX( int X){
        String data ="";
        if (X >= 0){
            Queue<Block> tempQ = new Queue<Block>();
            while(!QKranken.isEmpty()){
                tempQ.enqueue(QKranken.front());
                if (QKranken.front().getId() == X){
                    Block tempBlock =QKranken.front();
                    data =  "ID: " + tempBlock.getId() +
                            "\nEmpfänger " + tempBlock.getEmpfänger() +
                            "\nSender: " + tempBlock.getSender() +
                            "\nBetrag: " + tempBlock.getBetrag();
                }
                QKranken.dequeue();
            }
            QKranken = tempQ;
        }
        return data;
    }

    public Queue getBlocks(int ID){
        Queue<Block> searchedFor = new Queue<>();
        if (ID >= 0){
            Queue<Block> tempQ = new Queue<Block>();
            while(!QKranken.isEmpty()){
                tempQ.enqueue(QKranken.front());
                if (QKranken.front().getSender() == ID || QKranken.front().getEmpfänger() == ID){
                   searchedFor.enqueue(QKranken.front());
                }
                QKranken.dequeue();
            }
            QKranken = tempQ;
        }
        return searchedFor;
    }

    public void printBlocks(Queue<Block> eingabe){
        if(eingabe.isEmpty()){
            System.out.println("Empty");
        }
        Queue<Block> tempQ = new Queue<Block>();
        while(!eingabe.isEmpty()){
            tempQ.enqueue(eingabe.front());
                Block tempBlock = eingabe.front();
                System.out.println("Queue beinhaltet:");
                System.out.println("ID: " + tempBlock.getId() +
                        "\nEmpfänger " + tempBlock.getEmpfänger() +
                        "\nSender: " + tempBlock.getSender() +
                        "\nBetrag: " + tempBlock.getBetrag());
                System.out.println("--------------------------------");
            eingabe.dequeue();
        }
        eingabe = tempQ;
    }
    public static void main(String[] args) {
        KrankenHaus meinHaus = new KrankenHaus();
        Block one = new Block(5, 100, 23,32);
        Block two = new Block(18,200, 54,45);
        Block three = new Block(9,50, 87,78);
        Block four = new Block(1,6000, 98,89);
        Block five = new Block(44,400, 21,12);
        Block six = new Block(50,321, 52,23);

        meinHaus.addBlock(one);
        meinHaus.addBlock(two);
        meinHaus.addBlock(three);
        meinHaus.addBlock(four);
        meinHaus.addBlock(five);
        meinHaus.addBlock(six);
        /*
        //Count a
        System.out.println(meinHaus.countQ());

        //Mher als 100$ b
        System.out.println(meinHaus.countTransaktionOverX(100));

        //get Data with PNR
        System.out.println(meinHaus.getDataFromX(1));

        //get Block Emp = ID && Send == ID
        Queue eineNeueQ = meinHaus.getBlocks(23);
        meinHaus.printBlocks(eineNeueQ);
        */
    }
}
