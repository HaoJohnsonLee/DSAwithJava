package per.johnson.dsa.a.niuke;

/**
 * Created by Johnson on 2018/7/5.
 */
public class JumpFloor {
    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
     * 递归版本
     * @param target 台阶数目
     * @return 数目
     */
    public static int JumpFloor_0(int target) {
        if(target == 1) return 1;
        if(target == 2) return 2;
        return JumpFloor_0(target -1) + JumpFloor_0(target - 2);
    }

    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
     * 迭代版本
     * @param target 台阶数目
     * @return 数目
     */
    public static int JumpFloor_1(int target) {
        if(target == 1) return 1;
        if(target == 2) return 2;
        //Fibonacci 过程
        int f1 = 1;
        int f2 = 2;
        while(target -- > 2){
            f1 = f2 - f1;
            f2 = f1 + f2;
        }
        return f2;
    }

    /**
     * 变态跳台阶
     * 一只青蛙一次可以跳上1 - n 级台阶。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
     * 数学理解，n级台阶除了第n级都有两种可能(跳与不跳) 2^(n-1)种情况
     * @param target 数目
     * @return
     */
    public static int JumpFloor_bt(int target){
        return 1 << --target;
    }

    public static void main(String[] args) {
        System.out.println(JumpFloor_1(7));
    }
}
