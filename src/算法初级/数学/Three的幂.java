package 算法初级.数学;

/**
 * <p>
 * Created by tianyang on 2020/3/10.
 * 3的幂
 * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 27
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: 0
 * 输出: false
 * 示例 3:
 * <p>
 * 输入: 9
 * 输出: true
 * 示例 4:
 * <p>
 * 输入: 45
 * 输出: false
 */
public class Three的幂 {

    public boolean isPowerOfThree(int n) {
        if (n < 1) return false;
        while (n % 3 == 0) {
            n = n / 3;
        }
        return n == 1;
    }

    public boolean isPowerOfThree1(int n) {
        if (n <= 0) return false;
        else if (n == 1) return true;
        while (n > 1) {
            if (n % 3 != 0) return false;
            n = n / 3;
        }
        return true;
    }

}
