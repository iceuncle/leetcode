package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 在给定的网格中，每个单元格可以有以下三个值之一：
 * <p>
 * 值 0 代表空单元格；
 * 值 1 代表新鲜橘子；
 * 值 2 代表腐烂的橘子。
 * 每分钟，任何与腐烂的橘子（在 4 个正方向上）相邻的新鲜橘子都会腐烂。
 * <p>
 * 返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1。
 * <p>
 * 输入：[[2,1,1],[1,1,0],[0,1,1]]
 * 输出：4
 * 输入：[[2,1,1],[0,1,1],[1,0,1]]
 * 输出：-1
 * 解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个正向上。
 * 输入：[[0,2]]
 * 输出：0
 * 解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。
 */
public class Solution994 {

    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int row = grid.length, col = grid[0].length;
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1)
                    count++;
                else if (grid[i][j] == 2)
                    queue.add(new int[]{i, j});
            }
        }
        int minute = 0;
        while (count > 0 && !queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] node = queue.poll();
                int x = node[0], y = node[1];
                if (x - 1 >= 0 && grid[x - 1][y] == 1) {
                    grid[x - 1][y] = 2;
                    count--;
                    queue.add(new int[]{x - 1, y});
                }
                if (x + 1 < row && grid[x + 1][y] == 1) {
                    grid[x + 1][y] = 2;
                    count--;
                    queue.add(new int[]{x + 1, y});
                }
                if (y - 1 >= 0 && grid[x][y - 1] == 1) {
                    grid[x][y - 1] = 2;
                    count--;
                    queue.add(new int[]{x, y - 1});
                }

                if (y + 1 < col && grid[x][y + 1] == 1) {
                    grid[x][y + 1] = 2;
                    count--;
                    queue.add(new int[]{x, y + 1});
                }
            }
            minute++;
        }
        return count > 0 ? -1 : minute;
    }

}