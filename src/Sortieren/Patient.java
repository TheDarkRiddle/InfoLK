package Sortieren;

public class Patient implements ComparableContent<Patient>{

    private int ID;
    private String Krankheit;
    private double Grad;

    public Patient(int pID, String pKrankheit, double pGrad){
        ID = pID;
        Krankheit = pKrankheit;
        Grad = pGrad;
    }

    public int getID(){
        return ID;
    }

    public void setKrankheit(String pKrankheit){
        Krankheit = pKrankheit;
    }

    public String getKrankheit(){
        return Krankheit;
    }

    public double getGrad(){
        return Grad;
    }

    public void setGrad(double pGrad){
        Grad = pGrad;
    }

    public boolean isGreater(Patient pContent){
        if (pContent != null) {
            return this.getGrad() < pContent.getGrad();
        }
        return false;
    }

    public boolean isEqual(Patient pContent){
        if (pContent != null) {
            return this.getGrad() == pContent.getGrad();
        }
        return false;
    }

    public boolean isLess(Patient pContent){
        if (pContent != null) {
            return this.getGrad() > pContent.getGrad();
        }
        return false;
    }
}
