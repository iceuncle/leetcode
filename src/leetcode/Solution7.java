package leetcode;

/**
 * <p> 反转整数
 * Created by tianyang on 2018/11/2.
 * <p>
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 123
 * 输出: 321
 * <p>
 *  示例 2:
 * 输入: -123
 * 输出: -321
 * <p>
 * 示例 3:
 * 输入: 120
 * 输出: 21
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution7 {
    public int reverse(int x) {
        long res = 0;
        while (x != 0) {
            long yushu = x % 10;
            x = x / 10;
            res = res * 10 + yushu;
        }
        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE)
            return 0;
        return (int) res;
    }

    public static void main(String[] args) {
        System.out.println((new Solution7().reverse(123)));
        System.out.println((new Solution7().reverse(-123)));
    }

}
