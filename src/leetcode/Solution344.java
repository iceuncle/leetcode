package leetcode;

/**
 * <p>反转字符串
 * Created by tianyang on 2018/11/8.
 */
public class Solution344 {

    public String reverseString(String s) {
        char[] chars = s.toCharArray();
        int left = 0, right = s.length() - 1;
        while (left < right) {
            Character temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        return String.valueOf(chars);
    }

    public String reverseString1(String s) {
        StringBuilder builder = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            builder.append(s.charAt(i));
        }
        return builder.toString();
    }


    public static void main(String[] args) {
        System.out.println((new Solution344()).reverseString("hello"));
    }


}
