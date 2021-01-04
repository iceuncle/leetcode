package leetcode;

/**
 * 单词搜索
 * 回溯 dfs
 * <p>
 * 时间复杂度：一个非常宽松的上界为 O(MN \cdot 3^L)O(MN⋅3L)，其中 M, NM,N 为网格的长度与宽度，
 * LL 为字符串 \text{word}word 的长度。在每次调用函数 \text{check}check 时，除了第一次可以进入 44 个分支以外，
 * 其余时间我们最多会进入 33 个分支（因为每个位置只能使用一次，所以走过来的分支没法走回去）。
 * 由于单词长为 LL，故 \text{check(i, j, 0)}check(i, j, 0) 的时间复杂度为 O(3^L)O(3L)，
 * 而我们要执行 O(MN)O(MN) 次检查。然而，由于剪枝的存在，我们在遇到不匹配或已访问的字符时会提前退出，
 * 终止递归流程。因此，实际的时间复杂度会远远小于 \Theta(MN \cdot 3^L)Θ(MN⋅3L)。
 *
 * 空间复杂度：O(MN)O(MN)。我们额外开辟了 O(MN)O(MN) 的 \text{visited}visited 数组，
 * 同时栈的深度最大为 O(\min(L, MN))O(min(L,MN))。
 */
public class Solution79 {

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
        System.out.println(new Solution79().exist(new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}}, "ABCCED"));
        System.out.println(new Solution79().exist(new char[][]{
                {'C', 'A', 'A'},
                {'A', 'A', 'A'},
                {'B', 'C', 'D'}}, "AAB"));
        boolean[][] visited = new boolean[3][4];
        System.out.println(visited.length);
        System.out.println(visited[0].length);
    }

}
