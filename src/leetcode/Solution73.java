package leetcode;

import java.util.*;

public class Solution73 {

    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return;
        Set<Integer> rowSets = new HashSet<>();
        Set<Integer> colSets = new HashSet<>();
        int rows = matrix.length, cols = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    rowSets.add(i);
                    colSets.add(j);
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (rowSets.contains(i) || colSets.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public void setZeroes1(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return;
        boolean isCol = false;
        int rows = matrix.length, cols = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (j == 0 && matrix[i][0] == 0) {
                    isCol = true;
                    continue;
                }
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            }
        }
        if (matrix[0][0] == 0) {
            for (int i = 0; i < cols; i++) {
                matrix[0][i] = 0;
            }
        }
        if (isCol) {
            for (int i = 0; i < rows; i++) {
                matrix[i][0] = 0;
            }
        }
    }

}
