package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution52 {
    public int totalNQueens(int n) {
        char[][] chess = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                chess[i][j] = '.';
            }
        }
        List<List<String>> res = new ArrayList<>();
        solve(chess, res, 0);
        return res.size();
    }

    public void solve(char[][] chess, List<List<String>> res, int row) {
        if (row == chess.length) {
            res.add(construct(chess));
            return;
        }
        for (int col = 0; col < chess[0].length; col++) {
            if (!isValid(chess, row, col))
                continue;
            chess[row][col] = 'Q';
            solve(chess, res, row + 1);
            chess[row][col] = '.';
        }
    }

    public boolean isValid(char[][] chess, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (chess[i][col] == 'Q')
                return false;
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chess[i][j] == 'Q')
                return false;
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < chess[0].length; i--, j++) {
            if (chess[i][j] == 'Q')
                return false;
        }
        return true;
    }

    public List<String> construct(char[][] chess) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < chess.length; i++) {
            res.add(String.valueOf(chess[i]));
        }
        return res;
    }


}
