package 算法中极.动态规划;

public class 最长上升子序列 {

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

}
