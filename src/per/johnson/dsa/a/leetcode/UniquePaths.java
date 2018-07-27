package per.johnson.dsa.a.leetcode;

/**
 * Created by Johnson on 2018/7/22.
 */
public class UniquePaths {
    private int[][] map;
    public int uniquePaths(int m, int n) {
        map = new int[m+1][n+1];
        return calculate(m,n,map);
    }
    private int calculate(int m, int n, int[][] map){
        if (m <= 0 || n <= 0) return 0;
        map[1][1] = 1;
        if(map[m][n] > 0) return map[m][n];
        int left = uniquePaths(m - 1, n);
        int right = uniquePaths(m, n - 1);
        map[m][n] = left + right;
        return map[m][n];
    }

    public static void main(String[] args) {
        System.out.println(new UniquePaths().uniquePaths(15, 2));
    }
}
