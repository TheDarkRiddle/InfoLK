package Rekusion;

public class main {

    public int vielfaches(int number, int n){ // num=2 n=5 // 2 4 // 2 3 / 2 2 / 2 1
        if (n == 1){                          //
            return number;
        }
            else{
                return vielfaches( number, n-1) * n;
        }
    }

    public static void main(String[] args) {
        main a = new main();

        System.out.println(a.vielfaches(8,5));

    }

}