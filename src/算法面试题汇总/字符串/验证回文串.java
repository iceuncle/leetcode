package 算法面试题汇总.字符串;

/**
 * <p>
 * Created by tianyang on 2020/3/12.
 */
public class 验证回文串 {
    public boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (!Character.isLetterOrDigit(chars[left])) {
                left++;
            } else if (!Character.isLetterOrDigit(chars[right])) {
                right--;
            } else {
                if (Character.toLowerCase(chars[left]) == Character.toLowerCase(chars[right])) {
                    left++;
                    right--;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
