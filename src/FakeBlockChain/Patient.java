package FakeBlockChain;

public class Patient {
    private int alter;
    private String name;

    public Patient(int pAlter, String pName){
        alter = pAlter;
        name = pName;
    }

    public int getAlter() {
        return alter;
    }
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Name:"+getName()+"\nAlter:"+getAlter();
    }
}
