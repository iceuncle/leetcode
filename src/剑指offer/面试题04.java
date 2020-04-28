package 剑指offer;

/**
 * <p>
 * Created by tianyang on 2020/3/16.
 * 二维数组中的查找
 */
public class 面试题04 {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return false;
        int x = matrix.length - 1;
        int y = 0;
        while (x >= 0 && y <= matrix[0].length - 1) {
            int temp = matrix[x][y];
            if (target == temp)
                return true;
            else if (target < temp)
                x--;
            else
                y++;
        }
        return false;
    }

}
