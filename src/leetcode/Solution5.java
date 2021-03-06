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

    /**
     * 暴力解法
     * 时间复杂度O(n^3)
     * 空间复杂度O(1)
     */
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) return s;
        char[] charArray = s.toCharArray();
        int maxLength = 1;
        int begin = 0;
        // abcdef
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (j - i + 1 > maxLength && isPalindrome(charArray, i, j)) {
                    maxLength = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLength);
    }

    public boolean isPalindrome(char[] chars, int l, int r) {
        while (l < r) {
            if (chars[l] != chars[r])
                return false;
            l++;
            r--;
        }
        return true;
    }


    /**
     * 中心扩散解法
     * 时间复杂度O(n^2)
     * 空间复杂度O(1)
     */
    public String longestPalindrome1(String s) {
        int len = s.length();
        if (len < 2) return s;
        int maxLen = 1, begin = 0;
        char[] charArray = s.toCharArray();
        for (int i = 0; i < s.length() - 1; i++) {
            int count1 = expandCenter(charArray, i, i);
            int count2 = expandCenter(charArray, i, i + 1);
            int count = Math.max(count1, count2);
            if (count > maxLen) {
                maxLen = count;
                begin = i - (count - 1) / 2;
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    public int expandCenter(char[] charArray, int i, int j) {
        while (i >= 0 && j < charArray.length) {
            if (charArray[i] != charArray[j])
                break;
            else {
                i--;
                j++;
            }
        }
        return j - i - 1;
    }

    /**
     * 动态规划
     * 时间复杂度O(n^2)
     * 空间复杂度O(n^2)
     */
    public String longestPalindrome2(String s) {
        int len = s.length();
        if (len < 2) return s;
        int maxLen = 1, begin = 0;
        char[] charArray = s.toCharArray();
        Boolean[][] dp = new Boolean[len][len];
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (charArray[i] != charArray[j])
                    dp[i][j] = false;
                else {
                    if (j - i < 3) dp[i][j] = true;
                    else dp[i][j] = dp[i + 1][j - 1];
                }
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }


    public static void main(String[] args) {
        (new Solution5()).longestPalindrome("abacdfgdcaba");
    }

}
