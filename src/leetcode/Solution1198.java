package leetcode;

import java.util.Arrays;

/**
 * 找出所有行中最小公共元素
 */
public class Solution1198 {

    public int smallestCommonElement(int[][] mat) {
        int temp[] = new int[10001];
        int row = mat.length, col = mat[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (++temp[mat[i][j]] == row) {
                    return mat[i][j];
                }
            }
        }
        return -1;
    }

    public int smallestCommonElement1(int[][] mat) {
        int row = mat.length, col = mat[0].length;
        for (int j = 0; j < col; j++) {
            boolean check = true;
            for (int i = 1; i < row && check; i++) {
                check = Arrays.binarySearch(mat[i], mat[0][j]) >= 0;
            }
            if (check)
                return mat[0][j];
        }
        return -1;
    }


}
