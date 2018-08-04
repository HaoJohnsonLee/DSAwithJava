package per.johnson.dsa.a.niuke;

/**
 * Created by Johnson on 2018/7/29.
 *
 * 写一个函数，求两个整数之和
 * 要求在函数体内不得使用+、-、*、/四则运算符号。
 */
public class Add {
    public int add(int num1,int num2) {
        return (num1 & num2) == 0 ?  (num1 ^ num2) : add(num1 & num2, num1 ^ num2);
    }

    public static void main(String[] args) {
        System.out.println(new Add().add(111,899));
    }
}
