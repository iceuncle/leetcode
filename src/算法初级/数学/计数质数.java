package 算法初级.数学;

/**
 * <p>
 * Created by tianyang on 2020/3/10.
 * <p>
 * 统计所有小于非负整数 n 的质数的数量。
 * <p>
 * 示例:
 * <p>
 * 输入: 10
 * 输出: 4
 * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 */
public class 计数质数 {

    public int countPrimes(int n) {
        if (n < 2) return 0;
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrimes(i))
                count++;
        }
        return count;
    }

    private boolean isPrimes(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    public int countPrimes1(int n) {
        boolean[] primes = new boolean[n];
        for (int i = 2; i < n; i++) {
            if (isPrimes(i)) {
                primes[i] = true;
                for (int j = 2; j < n / i; j++) {
                    primes[j * i] = false;
                }
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (primes[i]) count++;
        }
        return count;
    }
}
