package leetcode;

/**
 * <p>爬楼梯 暴力递归
 *
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。

 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？

 注意：给定 n 是一个正整数。

 示例 1：

 输入： 2
 输出： 2
 解释： 有两种方法可以爬到楼顶。
 1.  1 阶 + 1 阶
 2.  2 阶
 示例 2：

 输入： 3
 输出： 3
 解释： 有三种方法可以爬到楼顶。
 1.  1 阶 + 1 阶 + 1 阶
 2.  1 阶 + 2 阶
 3.  2 阶 + 1 阶

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/climbing-stairs
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

 * Created by tianyang on 2018/11/6.
 */
public class Solution70 {
    public int climbStairs(int n) {
        return climbStairs(0, n);
    }

    public int climbStairs(int i, int n) {
        if (i == n - 2) return 2;
        else if (i == n - 1) return 1;
        return climbStairs(i + 1, n) + climbStairs(i + 2, n);
    }

    public static void main(String[] args) {
        System.out.println((new Solution70()).climbStairs(2));
        System.out.println((new Solution70()).climbStairs(3));
    }

    public int climbStairs1(int n) {
        int[] memo = new int[n + 1];
        return climbStairs1(0, n, memo);
    }

    public int climbStairs1(int i, int n, int[] memo) {
        if (i == n - 2) return 2;
        else if (i == n - 1) return 1;
        if (memo[i] > 0)
            return memo[i];
        memo[i] = climbStairs1(i + 1, n, memo) + climbStairs1(i + 2, n, memo);
        return memo[i];
    }



    public int climbStairs2(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int dp[] = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public int climbStairs3(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }

    public int climbStairs4(int n) {
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        return climbStairs4(n - 1) + climbStairs4(n - 2);
    }


}


