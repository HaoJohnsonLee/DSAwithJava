package per.johnson.dsa.a.interview;

/**
 * Created by Johnson on 2018/7/28.
 */
public class Hanoi {
    // O ( 2^n )
    public static void process(int n, String from, String to, String help) {
        if (n == 1) {
            System.out.println("Move " + n + " from " + from + " to " + to);
        } else {
            process(n - 1, from, help, to);
            System.out.println("Move " + n + " from " + from + " to " + to);
            process(n - 1, help, to, from);
        }
    }

    public static void main(String[] args) {
        process(3, "左", "右", "中");
    }
}
