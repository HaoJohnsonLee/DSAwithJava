package per.johnson.dsa.a.leetcode;

/**
 * Created by Johnson on 2018/7/22.
 */
public class UniquePathsII {
    private int[][] map;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) return 0;
        map = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int i = 0; i < map.length; i++)
            for (int j = 0; j < map[i].length; j++)
                map[i][j] = -1;
        return calculate(obstacleGrid, obstacleGrid.length-1, obstacleGrid[0].length-1, map);
    }

    private int calculate(int[][] obstacleGrid, int m, int n, int[][] map) {
        if (m < 0 || n < 0) return 0;
        map[0][0] = 1 - obstacleGrid[0][0];
        if (map[m][n] >= 0) return map[m][n];
        if (obstacleGrid[m][n] == 1) return 0;
        int left = calculate(obstacleGrid, m - 1, n, map);
        int right = calculate(obstacleGrid, m, n-1, map);
        map[m][n] = left + right;
        return map[m][n];
    }

    public static void main(String[] args) {
        //int[][] obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};
        int[][] obstacleGrid = {{0,0}};
        System.out.println(new UniquePathsII().uniquePathsWithObstacles(obstacleGrid));
    }
}
