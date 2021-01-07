package leetcode;

import java.util.Arrays;

public class Solution59 {

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int[][] direction = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int directionIndex = 0, row = 0, col = 0;
        for (int i = 1; i <= n * n; i++) {
            matrix[row][col] = i;
            int nextRow = row + direction[directionIndex][0];
            int nextCol = col + direction[directionIndex][1];
            if (nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= n || matrix[nextRow][nextCol] != 0) {
                directionIndex = (directionIndex + 1) % 4;
            }
            row += direction[directionIndex][0];
            col += direction[directionIndex][1];
        }
        return matrix;
    }

    public int[][] generateMatrix1(int n) {
        int[][] matrix = new int[n][n];
        int up = 0, down = n - 1, left = 0, right = n - 1;
        int num = 1;
        while (true) {
            for (int i = left; i <= right; i++) {
                matrix[up][i] = num++;
            }
            if (++up > down) break;
            for (int i = up; i <= down; i++) {
                matrix[i][right] = num++;
            }
            if (--right < left) break;
            for (int i = right; i >= left; i--) {
                matrix[down][i] = num++;
            }
            if (--down < up) break;
            for (int i = down; i >= up; i--) {
                matrix[i][left] = num++;
            }
            if (++left > right) break;
        }
        return matrix;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new Solution59().generateMatrix(3)));
        System.out.println(Arrays.deepToString(new Solution59().generateMatrix1(3)));
    }

}
