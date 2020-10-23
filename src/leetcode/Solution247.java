package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 中心对称数是指一个数字在旋转了 180 度之后看起来依旧相同的数字（或者上下颠倒地看）。 找到所有长度为 n 的中心对称数。
 * Example:
 * Input:  n = 2
 * Output: ["11","69","88","96"]
 */
public class Solution247 {

    public List<String> findStrobogrammatic(int n) {
        return helper(n, n);
    }

    public List<String> helper(int n, int length) {
        if (n == 0) return Arrays.asList("");
        else if (n == 1) return Arrays.asList("0", "1", "8");

        List<String> list = helper(n - 2, length);
        List<String> res = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            if (n != length)
                res.add("0" + s + "0");
            res.add("1" + s + "1");
            res.add("6" + s + "9");
            res.add("8" + s + "8");
            res.add("9" + s + "6");
        }
        return res;
    }
}
