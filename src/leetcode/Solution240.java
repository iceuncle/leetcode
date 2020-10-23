package leetcode;

public class Solution240 {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int x = matrix.length - 1, y = 0;
        while (y <= matrix[0].length - 1 && x >= 0) {
            if (target == matrix[x][y])
                return true;
            else if (target > matrix[x][y])
                y++;
            else if (target < matrix[x][y])
                x--;
        }
        return false;
    }

}
