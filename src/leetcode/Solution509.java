package leetcode;

/**
 * <p>
 * Created by tianyang on 2020/3/9.
 */
public class Solution509 {

    /**
     * 20
     * 19 18
     * 18 17 17 16
     * 3  2
     * 1 2  0  1
     *
     * @param N
     * @return
     */

    public int fib(int N) {
        int[] memo = new int[N + 1];
        return fib(memo, N);
    }

    public int fib(int[] memo, int N) {
        if (N == 0) return 0;
        else if (N == 1) return 1;
        if (memo[N] != 0) return memo[N];
        return fib(memo, N - 1) + fib(memo, N - 2);
    }


    public int fib1(int N) {
        if (N <= 1) return N;
        int[] memo = new int[N + 1];
        memo[0] = 0;
        memo[1] = 1;
        for (int i = 2; i < N + 1; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        return memo[N];
    }

    public int fib2(int N) {
        if (N <= 1) return N;
        int prev = 0, curr = 1;
        for (int i = 2; i <= N; i++) {
            int sum = prev + curr;
            prev = curr;
            curr = sum;
        }
        return curr;
    }

}
