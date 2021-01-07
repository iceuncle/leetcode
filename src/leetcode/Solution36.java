package leetcode;

import java.util.HashMap;

public class Solution36 {

    public boolean isValidSudoku(char[][] board) {
        HashMap<Character, Integer>[] rows = new HashMap[9];
        HashMap<Character, Integer>[] colums = new HashMap[9];
        HashMap<Character, Integer>[] boxes = new HashMap[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashMap<>();
            colums[i] = new HashMap<>();
            boxes[i] = new HashMap<>();
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.') continue;
                rows[i].put(c, rows[i].getOrDefault(c, 0) + 1);
                colums[j].put(c, colums[j].getOrDefault(c, 0) + 1);
                int boxIndex = (i / 3) * 3 + j / 3;
                boxes[boxIndex].put(c, boxes[boxIndex].getOrDefault(c, 0) + 1);
                if (rows[i].get(c) > 1 || colums[j].get(c) > 1 || boxes[boxIndex].get(c) > 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
