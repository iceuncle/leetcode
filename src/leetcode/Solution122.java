package leetcode;

/**
 * <p>买卖股票的最佳时机 II
 * Created by tianyang on 2018/11/7.
 */
public class Solution122 {

    public int maxProfit(int[] prices) {
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                sum += prices[i] - prices[i - 1];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println((new Solution122()).maxProfit(new int[]{10, 3, 8, 1, 7}));
    }


}
