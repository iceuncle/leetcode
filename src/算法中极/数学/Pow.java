package 算法中极.数学;

/**
 * Pow(x, n)
 */
public class Pow {

    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        double ans = 1;
        for (long i = 0; i < N; i++) {
            ans *= x;
        }
        return ans;
    }

    public double myPow1(double x, int n) {
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
        System.out.println(new Pow().myPow1(2, Integer.MIN_VALUE));
    }

}
