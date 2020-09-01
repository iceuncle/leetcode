package leetcode;

/**
 * 删除回文子数组
 * 给你一个整数数组 arr，每一次操作你都可以选择并删除它的一个 回文 子数组 arr[i], arr[i+1], ..., arr[j]（ i <= j）。
 * <p>
 * 注意，每当你删除掉一个子数组，右侧元素都会自行向前移动填补空位。
 * <p>
 * 请你计算并返回从数组中删除所有数字所需的最少操作次数。
 */
public class Solution1246 {

    public int minimumMoves(int[] arr) {
        int len = arr.length;
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
        }
        for (int i = 0; i < len - 1; i++)
            dp[i][i + 1] = arr[i] == arr[i + 1] ? 1 : 2;
        for (int j = 2; j < len; j++) {
            for (int i = j - 2; i >= 0; i--) {
                int min = j - i + 1;
                if (arr[i] == arr[j])
                    min = dp[i + 1][j - 1];
                for (int k = i; k < j; k++) {
                    min = Math.min(min, dp[i][k] + dp[k + 1][j]);
                }
                dp[i][j] = min;
            }
        }
        return dp[0][len - 1];
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 4, 1, 5};
        System.out.println(new Solution1246().minimumMoves(arr));

        int[] arr1 = new int[]{1, 3, 4, 5, 5};
        System.out.println(new Solution1246().minimumMoves(arr1));
    }
}
