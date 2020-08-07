package leetcode;

/**
 * <p>反转字符串中的单词 二
 * Created by tianyang on 2018/11/8.
 */
public class Solution355 {
    public String reverseWords(String s) {
        StringBuilder res = new StringBuilder();
        String[] words = s.split(" ");
        for (String word : words) {
            res.append(reverse(word)).append(" ");
        }
        return res.substring(0, res.length() - 1);
    }

    public String reverse(String s) {
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
