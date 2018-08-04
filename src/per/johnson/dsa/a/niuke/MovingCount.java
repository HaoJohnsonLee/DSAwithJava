package per.johnson.dsa.a.niuke;

/**
 * Created by Johnson on 2018/7/29.
 * <p>
 * 地上有一个m行和n列的方格。
 * 一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 */
public class MovingCount {
    public int movingCount(int threshold, int rows, int cols) {
        boolean[][] visited = new boolean[rows][cols];
        return count(threshold, rows, cols, 0, 0, visited);
    }

    private int count(int threshold, int rows, int cols, int curRow, int curCol, boolean[][] visited) {
        int count = 0;
        if (check(threshold, rows, cols, curRow, curCol, visited)) {
            visited[curRow][curCol] = true;
            count = 1 + count(threshold, rows, cols, curRow + 1, curCol, visited)
                    + count(threshold, rows, cols, curRow - 1, curCol, visited)
                    + count(threshold, rows, cols, curRow, curCol + 1, visited)
                    + count(threshold, rows, cols, curRow, curCol - 1, visited);
        }
        return count;
    }

    /**
     * 检查当前结点是否合法，并且可以进入
     *
     * @param threshold 数位和阈值
     * @param rows      全部行
     * @param cols      全部列
     * @param curRow    当前行
     * @param curCol    当前列
     * @param visited   访问表
     * @return
     */
    public boolean check(int threshold, int rows, int cols, int curRow, int curCol, boolean[][] visited) {
        return curCol >= 0 && curRow >= 0 && curCol < cols && curRow < rows
                && (getTotal(curCol) + getTotal(curRow) <= threshold)
                && !visited[curRow][curCol];
    }

    /**
     * 得到数位和
     *
     * @return
     */
    private int getTotal(int num1) {
        int count = 0;
        while (num1 != 0) {
            count += num1 % 10;
            num1 /= 10;
        }
        return count;
    }

    public static void main(String[] args) {
        MovingCount count = new MovingCount();
        System.out.println(count.movingCount(5,10,10));
    }
}
