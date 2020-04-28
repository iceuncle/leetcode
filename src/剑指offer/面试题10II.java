package 剑指offer;

/**
 * <p>
 * Created by tianyang on 2020/3/16.
 * 青蛙跳台阶问题
 */
public class 面试题10II {
    public int numWays(int n) {
        int[] memo = new int[n + 1];
        return numWays(n, memo);
    }

    public int numWays(int n, int[] memo) {
        if (n == 0) return 1;
        else if (n <= 2) return n;
        if (memo[n] > 0)
            return memo[n];
        memo[n] = (numWays(n - 1, memo) + numWays(n - 2, memo)) % 1000000007;
        return memo[n];
    }
}
