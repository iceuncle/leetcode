package leetcode;

/**
 * <p>反转字符串中的单词 二
 * Created by tianyang on 2018/11/8.
 */
public class Solution355 {
    public String reverseWords(String s) {
        String[] stringArr = s.split(" ");
        for (int i = 0; i < stringArr.length; i++) {
            stringArr[i] = reverse(stringArr[i]);
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < stringArr.length; i++) {
            builder.append(stringArr[i]);
            if (i != stringArr.length - 1) {
                builder.append(" ");
            }
        }
        return builder.toString();
    }

    private String reverse(String s) {
        char[] chars = s.toCharArray();
        int left = 0, right = s.length() - 1;
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        System.out.println((new Solution355()).reverseWords(" "));
        System.out.println((new Solution355()).reverseWords("Let's take LeetCode contest"));
    }
}
