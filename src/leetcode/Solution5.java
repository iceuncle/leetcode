package leetcode;

/**
 * <p>最长回文子串
 * Created by tianyang on 2018/11/2.
 * <p>
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution5 {

    public String longestPalindrome(String s) {
        String maxStr = "";
        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String sub = s.substring(i, j + 1);
                System.out.println(sub);
                int count = 0;
                for (int k = 0; k < sub.length() / 2; k++) {
                    if (sub.charAt(k) == sub.charAt(sub.length() - 1 - k))
                        count++;
                }
                if (count == sub.length() / 2 && maxLen < sub.length()) {
                    maxLen = sub.length();
                    maxStr = sub;
                }
            }
        }
        System.out.println(maxStr);
        return maxStr;
    }


    public static void main(String[] args) {
        (new Solution5()).longestPalindrome("abacdfgdcaba");
    }

}
