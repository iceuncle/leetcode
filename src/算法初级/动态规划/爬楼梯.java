package 算法初级.动态规划;

/**
 * <p>
 * Created by tianyang on 2020/3/10.
 * <p>
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 注意：给定 n 是一个正整数。
 * <p>
 * 示例 1：
 * <p>
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 * <p>
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 * <p>
 * 1 2 3
 */
public class 爬楼梯 {

    public int climbStairs(int n) {
        if (n <= 2) return n;
        int prev = 1;
        int curr = 2;
        for (int i = 3; i <= n; i++) {
            int temp = curr;
            curr = prev + curr;
            prev = temp;
        }
        return curr;
    }

    public int climbStairs1(int n) {
        int[] memo = new int[n + 1];
        return climbStairs1(memo, n);
    }

    public int climbStairs1(int[] memo, int n) {
        if (n <= 2) return n;
        if (memo[n] > 0) return memo[n];
        memo[n] = climbStairs1(memo, n - 1) + climbStairs1(memo, n - 2);
        return memo[n];
    }
}
