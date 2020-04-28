package leetcode;

/**
 * <p>买卖股票的最佳时机  暴力循环
 * Created by tianyang on 2018/11/7.
 */
public class Solution121 {
    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                if (profit > max)
                    max = profit;
            }
        }
        return max;
    }

    public int maxProfit1(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] <= min) {
                min = prices[i];
            } else if (prices[i] - min > max) {
                max = prices[i] - min;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println((new Solution121()).maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println((new Solution121()).maxProfit(new int[]{7, 6, 4, 3, 1}));
    }
}
