package leetcode;

import java.util.*;

/**
 * 中心对称数是指一个数字在旋转了 180 度之后看起来依旧相同的数字（或者上下颠倒地看）。 写一个函数来计算范围在 [low, high] 之间中心对称数的个数。
 * Example:
 * Input: low = "50", high = "100"
 * Output: 3
 * Explanation: 69, 88, and 96 are three strobogrammatic numbers.
 */
public class Solution248 {

    public int strobogrammaticInRange(String low, String high) {
        int lowInt = Integer.parseInt(low);
        int highInt = Integer.parseInt(high);
        int size = 0;
        for (int i = lowInt; i <= highInt; i++) {
            if (isStrobogrammatic(i))
                size++;
        }
        return size;
    }

    public boolean isStrobogrammatic(int n) {
        String s = String.valueOf(n);
        int left = 0, right = s.length() - 1;
        HashMap<Character, Character> map = new HashMap<>();
        map.put('0', '0');
        map.put('1', '1');
        map.put('6', '9');
        map.put('8', '8');
        map.put('9', '6');
        while (left < right) {
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);
            if (!map.containsKey(leftChar) || !map.containsKey(rightChar))
                return false;
            if (map.get(leftChar) != map.get(rightChar))
                return false;
            left++;
            right--;
        }
        return true;
    }

    public int strobogrammaticInRange1(String low, String high) {
        List<String> result = new ArrayList<>();
        List<String> listLow = helper(low.length(), low.length());
        listLow.removeIf(s -> Long.parseLong(s) < Long.parseLong(low));
        result.addAll(listLow);
        if (low.length() < high.length()) {
            List<String> listHigh = helper(high.length(), high.length());
            listHigh.removeIf(s -> Long.parseLong(s)> Long.parseLong(high));
            result.addAll(listHigh);
        }else
            result.removeIf(s -> Long.parseLong(s)> Long.parseLong(high));
        return result.size();
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

    public static void main(String[] args) {
        System.out.println(new Solution248().strobogrammaticInRange("50", "100"));
        System.out.println(new Solution248().strobogrammaticInRange1("50", "100"));
    }
}
