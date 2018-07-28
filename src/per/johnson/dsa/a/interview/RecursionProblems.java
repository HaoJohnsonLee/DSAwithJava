package per.johnson.dsa.a.interview;

import per.johnson.dsa.util.ArrayUtil;

import java.util.Arrays;

/**
 * Created by Johnson on 2018/7/28.
 */
public class RecursionProblems {
    /**
     * 打印字符串所有的子序列
     *
     * @param str 输入的字符串序列
     * @param i   当前指针位置
     * @param res 上层传递的串
     */
    private static void printAllSubString(char[] str, int i, String res) {
        if (i == str.length) {
            System.out.println(res);
        } else {
            printAllSubString(str, i + 1, res);
            printAllSubString(str, i + 1, res + str[i]);
        }
    }

    /**
     * 有一头母牛，它每年年初生一头小母牛
     * 每头小母牛从第四个年头开始，每年年初也生一头小母牛
     *
     * @param n 年份
     * @return n年后牛的数量
     * f(n) = f(n-1) + f(n - 3)
     * 第 n 年的牛数量由两部分构成 : 前一年的牛和三年前存在的牛生出的小牛
     */
    private static int cow(int n) {
        if (n < 4) return n;
        return cow(n - 1) + cow(n - 3);
    }

    // dp 版本
    private static int cow_dp(int n) {
        if (n <= 4) return n;
        int f1 = 4, f2 = 3, f3 = 2, fn = 5;
        for (int i = 5; i <= n; i++) {
            fn = f1 + f3;
            f3 = f2;
            f2 = f1;
            f1 = fn;
        }
        return fn;
    }

    /**
     * 给出二维数组，从（0，0）出发，只能 向下 & 向右 走，问到达右下角最短路径
     * <p>
     * 求起始点即设置参数 --> 0 , 0
     *
     * @param matrix 数组
     * @param i      当前位置 行
     * @param j      当前位置 列
     * @return 最短路径
     */
    private static int walk(int[][] matrix, int i, int j) {
        if (i == matrix.length - 1 && j == matrix[0].length - 1) {
            return matrix[i][j];
        }
        if (i == matrix.length - 1) {
            return matrix[i][j] + walk(matrix, i, j + 1);
        }
        if (j == matrix[0].length - 1) {
            return matrix[i][j] + walk(matrix, i + 1, j);
        }
        return matrix[i][j] + Math.min(walk(matrix, i + 1, j), walk(matrix, i, j + 1));
    }

    private static int walk_dp(int[][] matrix){
        int row = matrix.length - 1;
        int column = matrix[0].length - 1;
        int[][] dp = new int[row + 1][column + 1];
        dp[row][column] = matrix[row][column];
        for(int i = column-1; i>=0;i--){
            dp[row][i] = dp[row][i+1] + matrix[row][i];
        }
        for(int i = row-1; i>=0;i--){
            dp[i][column] = dp[i+1][column] + matrix[i][column];
        }
        for(int i = column -1; i>=0; i--){
            for(int j = row -1; j>=0;j--){
                dp[i][j] = matrix[i][j] + Math.min(dp[i+1][j],dp[i][j+1]);
            }
        }
        System.out.println("-----------dp array-------------");
        System.out.println(ArrayUtil.array2String(dp));
        return dp[0][0];
    }

    //测试walk
    private static void testWalk() {
        int[][] matrix = ArrayUtil.generateRandomMatrix(10,10);
        System.out.println("-----------origin array-------------");
        System.out.println(ArrayUtil.array2String(matrix));
        System.out.println(walk(matrix, 0, 0));
        System.out.println(walk_dp(matrix));
    }

    /**
     * 在数组中，是否存在几个数的和为 aim
     *
     * @param array 数组
     * @param aim aim
     * @return true if exist
     */
    private static boolean isAimExist(int[] array,int aim){
        return isAimExist(array,0,0,aim);
    }
    private static boolean isAimExist(int[] array,int i,int sum, int aim){
        if(sum == aim) return true;
        if(i == array.length) return false;
        return isAimExist(array,i + 1,sum,aim)||isAimExist(array,i+1,sum+array[i],aim);
    }


    public static void main(String[] args) {
        int[] a = {3,2,7,13};
        System.out.println(isAimExist(a,9));
    }
}
