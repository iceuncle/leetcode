package other;

/**
 * <p>
 * Created by tianyang on 2020/3/9.
 * <p>
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * 示例 1:
 * <p>
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * 示例 2:
 * <p>
 * 输入: coins = [2], amount = 3
 * 输出: -1
 * <p>
 * <p>
 * <p>
 * f(n)   n==0 0
 * n<0 -1
 * n>0 min f(n-coin) + 1  coin in coins
 */
public class 零钱兑换 {

    public int coinChange(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        return coinChange(memo, coins, amount);
    }

    public int coinChange(int[] memo, int[] coins, int amount) {
        if (amount == 0) return 0;
        else if (amount < 0) return -1;
        if (memo[amount] != 0)
            return memo[amount];
        int ret = Integer.MAX_VALUE;
        for (int coin : coins) {
            int numbers = coinChange(memo, coins, amount - coin);
            if (numbers == -1)
                continue;
            ret = Math.min(ret, numbers + 1);
        }
        if (ret == Integer.MAX_VALUE)
            memo[amount] = -1;
        else
            memo[amount] = ret;
        return memo[amount];
    }

    public static void main(String[] args) {
        System.out.println(new 零钱兑换().coinChange(new int[]{1, 2, 5}, 11));
    }
}
