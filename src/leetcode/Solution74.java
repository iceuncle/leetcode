package leetcode;

public class Solution74 {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = m * n - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int row = mid / n, col = mid % n;
            if (target == matrix[row][col])
                return true;
            else if (target < matrix[row][col])
                right = mid - 1;
            else
                left = mid + 1;
        }
        return false;
    }

    public boolean searchMatrix1(int[][] matrix, int target) {
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
