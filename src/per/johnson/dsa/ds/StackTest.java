package per.johnson.dsa.ds;

/**
 * Created by Johnson on 2018/6/30.
 */
public class StackTest {
    public static void main(String[] args) {
        String exp = "{[(5 + 6)/7]-15}+8";
        System.out.println(Stack.paren(exp));
    }
}
