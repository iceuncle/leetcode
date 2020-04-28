package 探索字节跳动.挑战字符串;

/**
 * <p>
 * Created by tianyang on 2020/3/27.
 */
public class 最长公共前缀 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (prefix.length() > 0) {
                if (strs[i].indexOf(prefix) == 0)
                    break;
                else {
                    prefix = prefix.substring(0, prefix.length() - 1);
                }
            }
        }
        return prefix;
    }


}
