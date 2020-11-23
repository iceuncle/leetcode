package 算法中极.排序与搜素;

public class 搜索二维矩阵II {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        int row = matrix.length, col = matrix[0].length;
        int i = row - 1, j = 0;
        while (i >= 0 && j < col) {
            if (target == matrix[i][j])
                return true;
            else if (target < matrix[i][j])
                i--;
            else
                j++;
        }
        return false;
    }

}
