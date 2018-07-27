package per.johnson.dsa.a.leetcode;

/**
 * Created by Johnson on 2018/7/22.
 */
public class MinimumPathSum {
    /**
     *
     * @param grid
     *    [1,3,1],
     *   [1,5,1],
     *   [4,2,1]
     * @return 7
     */
    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length ==0 || grid[0].length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        for(int i=0; i< m; i++) {
            for (int j = 0; j < n; j++) {
                if(i ==0 && j ==0) continue;
                if(i == 0) grid[i][j] = grid[i][j] + grid[i][j - 1];
                else if(j == 0) grid[i][j] = grid[i][j] + grid[i - 1][j];
                else grid[i][j] = grid[i][j] + Math.min(grid[i][j-1],grid[i-1][j]);
            }
        }
        return grid[m-1][n-1];
    }

    public static void main(String[] args) {
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(new MinimumPathSum().minPathSum(grid));
    }
}
