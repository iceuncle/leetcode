package 算法中极.数组与字符串;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 矩阵置零 {

    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        int row = matrix.length;
        int col = matrix[0].length;
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0)
                    list.add(Arrays.asList(i, j));
            }
        }
        for (int i = 0; i < list.size(); i++) {
            int x = list.get(i).get(0), y = list.get(i).get(1);
            for (int k = 0; k < row; k++)
                matrix[k][y] = 0;
            for (int k = 0; k < col; k++)
                matrix[x][k] = 0;
        }
    }


}
