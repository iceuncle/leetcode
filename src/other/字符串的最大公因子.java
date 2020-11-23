package other;

/**
 * <p>
 * Created by tianyang on 2020/3/12.
 * <p>
 * 对于字符串 S 和 T，只有在 S = T + ... + T（T 与自身连接 1 次或多次）时，我们才认定 “T 能除尽 S”。
 * <p>
 * 返回最长字符串 X，要求满足 X 能除尽 str1 且 X 能除尽 str2。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：str1 = "ABCABC", str2 = "ABC"
 * 输出："ABC"
 * 示例 2：
 * <p>
 * 输入：str1 = "ABABAB", str2 = "ABAB"
 * 输出："AB"
 * 示例 3：
 * <p>
 * 输入：str1 = "LEET", str2 = "CODE"
 * 输出：""
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= str1.length <= 1000
 * 1 <= str2.length <= 1000
 * str1[i] 和 str2[i] 为大写英文字母
 */
public class 字符串的最大公因子 {

    public String gcdOfStrings(String str1, String str2) {
        int len1 = str1.length(), len2 = str2.length();
        for (int i = Math.min(len1, len2); i > 0; i--) {
            if (len1 % i == 0 && len2 % i == 0) {
                String x = str1.substring(0, i);
                if (check(x, str1) && check(x, str2))
                    return x;
            }
        }
        return "";
    }

    public boolean check(String k, String t) {
        int len1 = k.length(), len2 = t.length();
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < len2 / len1; i++) {
            temp.append(k);
        }
        return temp.toString().equals(t);
    }

}
