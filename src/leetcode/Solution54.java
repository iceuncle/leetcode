package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution54 {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return res;
        int rows = matrix.length, cols = matrix[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int directionIndex = 0, row = 0, col = 0;
        for (int i = 0; i < rows * cols; i++) {
            res.add(matrix[row][col]);
            visited[row][col] = true;
            int nextRow = row + directions[directionIndex][0];
            int nextCol = col + directions[directionIndex][1];
            if (nextRow < 0 || nextRow >= rows || nextCol < 0 || nextCol >= cols || visited[nextRow][nextCol]) {
                directionIndex = (directionIndex + 1) % 4;
            }
            row = row + directions[directionIndex][0];
            col = col + directions[directionIndex][1];
        }
        return res;
    }

    public List<Integer> spiralOrder1(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return res;
        int up = 0, down = matrix.length - 1, left = 0, right = matrix[0].length - 1;
        while (true) {
            for (int i = left; i <= right; i++) {
                res.add(matrix[up][i]);
            }
            if (++up > down) break;
            for (int i = up; i <= down; i++) {
                res.add(matrix[i][right]);
            }
            if (--right < left) break;
            for (int i = right; i >= left; i--) {
                res.add(matrix[down][i]);
            }
            if (--down < up) break;
            for (int i = down; i >= up; i--) {
                res.add(matrix[i][left]);
            }
            if (++left > right) break;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution54().spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
        System.out.println(new Solution54().spiralOrder1(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
    }

}
