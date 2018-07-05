package per.johnson.dsa.a.niuke;

/**
 * Created by Johnson on 2018/7/5.
 */
public class Power {
    /**
     * 当n为偶数，a^n =（a^n/2）*（a^n/2）
     * 当n为奇数，a^n = a^[(n-1)/2] * a^[(n-1)/2] * a
     * @param base 底数
     * @param exponent 指数
     * @return
     */
    public static double Power(double base, int exponent) {
        int n = exponent >= 0 ? exponent: - exponent;
        if(n == 0) return 1;
        if(n == 1) return base;
        double result;
        result = Power(base, n >> 1);
        result = result * result;
        if((n & 1) == 1){
            result = result * base;
        }
        return exponent >= 0 ? result : (1/result);
    }

    public static void main(String[] args) {
        System.out.println(Power(2,-11));
    }
}
