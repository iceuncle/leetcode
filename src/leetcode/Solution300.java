package leetcode;

import java.util.Arrays;

public class Solution300 {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        int res = 0;
//        Arrays.fill(dp, 1);
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution300().lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3}));
    }
}
