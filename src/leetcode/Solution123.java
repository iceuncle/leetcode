package leetcode;

public class Solution123 {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int buy1 = -prices[0], sell1 = 0;
        int buy2 = -prices[0], sell2 = 0;
        for (int i = 1; i < n; ++i) {
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(sell1, prices[i] + buy1);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, prices[i] + buy2);
        }
        return sell2;

    }

    public static void main(String[] args) {
        System.out.println(new Solution123().maxProfit(new int[]{3, 5, 1, 7}));

//        System.out.println(new Solution123().maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4}));
    }
}
