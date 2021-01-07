package leetcode;

/**
 * 50. Pow(x, n)
 */
public class Solution50 {

    public double myPow(double x, int n) {
        if (x == 0) return 0;
        if (x == 1 || n == 0) return 1;
        long N = n;
        if (N < 0) return 1 / helper(x, -N);
        else return helper(x, N);
    }

    public double helper(double x, long n) {
        if (n == 1) return x;
        double half = helper(x, n / 2);
        if (n % 2 != 0) {
            return half * half * x;
        } else {
            return half * half;
        }
    }


    public static void main(String[] args) {
        System.out.println(new Solution50().myPow(-1, Integer.MIN_VALUE));
    }

}
