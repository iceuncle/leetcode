package 算法中极.动态规划;

public class 零钱兑换 {


    public int coinChange(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        return coinChange(coins, amount, memo);
    }


    public int coinChange(int[] coins, int amount, int[] memo) {
        if (amount == 0) return 0;
        else if (amount < 0) return -1;
        if (memo[amount] != 0) return memo[amount];
        int ret = Integer.MAX_VALUE;
        for (int coin : coins) {
            int count = coinChange(coins, amount - coin, memo);
            if (count == -1)
                continue;
            ret = Math.min(ret, count + 1);
        }
        memo[amount] = ret == Integer.MAX_VALUE ? -1 : ret;
        return memo[amount];
    }

    public static void main(String[] args) {
        System.out.println(new 零钱兑换().coinChange(new int[]{1, 2, 5}, 11));
    }

}
