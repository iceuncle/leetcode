package 算法中极.回溯算法;

public class 单词搜索 {

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0 || word.length() == 0)
            return false;
        int row = board.length, col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (check(board, i, j, 0, word, visited))
                    return true;
            }
        }
        return false;
    }

    private boolean check(char[][] board, int i, int j, int index, String word, boolean[][] visited) {
        if (board[i][j] != word.charAt(index))
            return false;
        else if (index == word.length() - 1)
            return true;
        visited[i][j] = true;

        int[][] direction = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int k = 0; k < direction.length; k++) {
            int newI = direction[k][0] + i;
            int newJ = direction[k][1] + j;
            if (newI >= 0 && newI < board.length && newJ >= 0 && newJ < board[0].length) {
                if (!visited[newI][newJ] && check(board, newI, newJ, index + 1, word, visited))
                    return true;
            }
        }
        visited[i][j] = false;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new 单词搜索().exist(new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}}, "ABCCED"));
    }
}
