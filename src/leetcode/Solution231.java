package leetcode;

/**
 * <p>2的幂
 * Created by tianyang on 2018/11/8.
 */
public class Solution231 {

    //1,2,3,4,5
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        return (n & (n - 1)) == 0;
    }

    public boolean isPowerOfTwo1(int n) {
        if (n <= 0) return false;
        while (n > 1) {
            if (n % 2 != 0) return false;
            n = n / 2;
        }
        return true;
    }

}
