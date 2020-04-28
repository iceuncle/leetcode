package 剑指offer;

/**
 * <p>
 * Created by tianyang on 2020/3/16.
 * 斐波那契数列
 */
public class 面试题10I {
    public int fib(int n) {
        if (n <= 1) return n;
        int pre = 0, cur = 1;
        for (int i = 2; i <= n; i++) {
            int temp = (pre + cur) % 1000000007;
            pre = cur;
            cur = temp;
        }
        return cur;
    }

    public int fib1(int n) {
        int[] memo = new int[n + 1];
        return fib1(n, memo);
    }

    public int fib1(int n, int[] memo) {
        if (n <= 1) return n;
        if (memo[n] > 0) return memo[n];
        memo[n] = (fib1(n - 1, memo) + fib1(n - 2, memo)) % 1000000007;
        return memo[n];
    }

}
