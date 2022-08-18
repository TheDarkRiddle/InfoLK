package Person;

abstract class Person {
    //Atribs
    private String name;
    private int alter;

    //__Methods__
    public Person(int pAlter, String pName){
        alter = pAlter;
        name = pAlter;
    }
    //Getter
    String getName(){ return name;}
    int getAlter(){ return alter;}

    //Setter
    public void setName(String pName){ name = pName;}
}
