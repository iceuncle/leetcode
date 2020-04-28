package 剑指offer;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <p>
 * Created by tianyang on 2020/3/27.
 * 矩阵中的路径
 */
public class 面试题12 {
    public boolean exist(char[][] board, String word) {
        char[] chars = word.toCharArray();
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == chars[0]) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        int index = 0;
        if (!queue.isEmpty()) index++;
        while (!queue.isEmpty() && index < chars.length) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] head = queue.poll();
                int x = head[0];
                int y = head[1];
                if (x - 1 >= 0 && board[x - 1][y] == chars[index]) {
                    queue.add(new int[]{x - 1, y});
                }
                if (x + 1 < board.length && board[x + 1][y] == chars[index]) {
                    queue.add(new int[]{x + 1, y});
                }
                if (y - 1 >= 0 && board[x][y - 1] == chars[index]) {
                    queue.add(new int[]{x, y - 1});
                }
                if (y + 1 < board[x].length && board[x][y + 1] == chars[index]) {
                    queue.add(new int[]{x, y + 1});
                }
            }
            if (!queue.isEmpty())
                index++;
        }
        return index == chars.length;
    }

    public static void main(String[] args) {
        boolean a = (new 面试题12()).exist((new char[][]{{'A', 'A'}}), "AA");
        System.out.println(a);
    }

}
