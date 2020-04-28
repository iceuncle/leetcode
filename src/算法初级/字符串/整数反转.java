package 算法初级.字符串;

/**
 * <p>
 * Created by tianyang on 2020/3/4.
 * <p>
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 123
 * 输出: 321
 * 示例 2:
 * <p>
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * <p>
 * 输入: 120
 * 输出: 21
 * 注意:
 * <p>
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 */
public class 整数反转 {

    public int reverse(int x) {
        long ret = 0;
        while (x != 0) {
            int yushu = x % 10;
            ret = ret * 10 + yushu;
            x = x / 10;
        }
        if (ret < Integer.MIN_VALUE || ret > Integer.MAX_VALUE)
            return 0;
        return (int) ret;
    }

    public int reverse1(int x) {
        int ret = 0;
        while (x != 0) {
            int pop = x % 10;
            if (ret > Integer.MAX_VALUE / 10 || (ret == Integer.MAX_VALUE / 10 && pop > Integer.MAX_VALUE % 10))
                return 0;
            if (ret < Integer.MIN_VALUE / 10 || (ret == Integer.MIN_VALUE / 10 && pop < Integer.MIN_VALUE % 10))
                return 0;
            ret = ret * 10 + pop;
            x = x / 10;
        }
        return ret;
    }

    /**
     * ret * 10 + yushu > max
     * ret>(max-yushu)/10
     */

    public static void main(String[] args) {
        System.out.println((new 整数反转()).reverse(-123));
    }

}
