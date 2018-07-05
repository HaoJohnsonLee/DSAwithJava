package per.johnson.dsa.a.niuke;

/**
 * Created by Johnson on 2018/7/5.
 */
public class Fibonacci {
    static int[] fibonacci;
    public static int Fibonacci0(int n){
        if(n == 0) return 0;
        fibonacci = new int[n>2?n:2];
        fibonacci[0] = 1;
        fibonacci[1] = 1;
        for(int i = 2; i< n; i++){
            fibonacci[i] = fibonacci[i-1] + fibonacci[i-2];
        }
        return fibonacci[n - 1];
    }
    public static int Fibonacci1(int n){ // 39 - 63245986
        if(n == 0) return 0;
        int n1 = 0;
        int n2 = 1;
        while (n-- > 2){
            n1 = n2 - n1;
            n2 = n1 + n2;
        }
        return n2;
    }
    public static void main(String[] args) {
        System.out.println(Fibonacci1(45));
    }
}
