package 算法中极.树和图;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 岛屿数量 {

    /**
     * 深度优先遍历
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        int row = grid.length, col = grid[0].length;
        int res = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }

    private void dfs(char[][] grid, int i, int j) {
        int row = grid.length, col = grid[0].length;
        if (i < 0 || i >= row || j < 0 || j >= col || grid[i][j] == '0')
            return;
        grid[i][j] = '0';
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }

    /**
     * 广度优先遍历
     */
    public int numIslands1(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        int row = grid.length, col = grid[0].length;
        int res = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    bfs(grid, i, j);
                }
            }
        }
        return res;
    }

    private void bfs(char[][] grid, int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        grid[i][j] = '0';
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int[] node = queue.poll();
                int x = node[0], y = node[1];
                if (x - 1 >= 0 && grid[x - 1][y] == '1') {
                    queue.add(new int[]{x - 1, y});
                    grid[x - 1][y] = '0';
                }
                if (x + 1 < grid.length && grid[x + 1][y] == '1') {
                    queue.add(new int[]{x + 1, y});
                    grid[x + 1][y] = '0';
                }
                if (y - 1 >= 0 && grid[x][y - 1] == '1') {
                    queue.add(new int[]{x, y - 1});
                    grid[x][y - 1] = '0';
                }
                if (y + 1 < grid[0].length && grid[x][y + 1] == '1') {
                    queue.add(new int[]{x, y + 1});
                    grid[x][y + 1] = '0';
                }
            }
        }
    }


}
