package 算法面试题汇总.开始之前;

/**
 * <p>
 * Created by tianyang on 2020/3/12.
 */
public class 搜索二维矩阵II {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return false;
        int x = matrix.length - 1;
        int y = 0;
        while (y < matrix[0].length && x >= 0) {
            if (matrix[x][y] < target)
                y++;
            else if (matrix[x][y] > target) {
                x--;
            } else if (matrix[x][y] == target)
                return true;
        }
        return false;
    }
}
