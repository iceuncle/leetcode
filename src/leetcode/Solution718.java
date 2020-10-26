package leetcode;

public class Solution718 {

    public int findLength(int[] A, int[] B) {
        int res = 0;
        int m = A.length, n = B.length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i] == B[j])
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                else
                    dp[i + 1][j + 1] = 0;
                res = Math.max(dp[i + 1][j + 1], res);
            }
        }
        return res;
    }

}
