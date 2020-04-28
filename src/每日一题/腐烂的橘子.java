package 每日一题;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <p>
 * Created by tianyang on 2020/3/6.
 */
public class 腐烂的橘子 {

    public int orangesRotting(int[][] grid) {
        int lines = grid.length;
        int columns = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == 1) {
                    //记录所有好橘子个数
                    count++;
                } else if (grid[i][j] == 2) {
                    //入队当前所有坏橘子
                    queue.add(new int[]{i, j});
                }
            }
        }
        int minutes = 0;
        while (count > 0 && !queue.isEmpty()) {
            minutes++;
            //先腐烂当前所有烂橘子周围的好橘子
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] head = queue.poll();
                int x = head[0];
                int y = head[1];
                if (x - 1 >= 0 && grid[x - 1][y] == 1) {
                    grid[x - 1][y] = 2;
                    queue.add(new int[]{x - 1, y});
                    count--;
                }
                if (x + 1 < lines && grid[x + 1][y] == 1) {
                    grid[x + 1][y] = 2;
                    queue.add(new int[]{x + 1, y});
                    count--;
                }
                if (y - 1 >= 0 && grid[x][y - 1] == 1) {
                    grid[x][y - 1] = 2;
                    queue.add(new int[]{x, y - 1});
                    count--;
                }
                if (y + 1 < columns && grid[x][y + 1] == 1) {
                    grid[x][y + 1] = 2;
                    queue.add(new int[]{x, y + 1});
                    count--;
                }
            }
        }
        if (count > 0) {
            return -1;
        } else {
            return minutes;
        }
    }


}
