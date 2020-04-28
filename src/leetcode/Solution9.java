package leetcode;

/**
 * <p>回文数
 * Created by tianyang on 2018/11/5.
 * <p>
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 121
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 * <p>
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution9 {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        int number = 0;
        while (x > number) {
            number = number * 10 + x % 10;
            x /= 10;
        }
        return x == number || x == number / 10;
    }

//    public boolean isPalindrome(int x) {
//        if (x < 0) return false;
//        int number = x;
//        int cur = 0;
//        while (number > 0) {
//            cur = number % 10 + cur * 10;
//            number = number / 10;
//        }
//        return  x == cur;
//    }

    public static void main(String[] args) {
        System.out.println((new Solution9()).isPalindrome(12321));
        System.out.println((new Solution9()).isPalindrome(123321));
        System.out.println((new Solution9()).isPalindrome(123421));
    }
}