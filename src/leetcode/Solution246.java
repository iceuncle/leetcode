package leetcode;

import java.util.HashMap;

/**
 * 中心对称数
 * 中心对称数是指一个数字在旋转了 180 度之后看起来依旧相同的数字（或者上下颠倒地看）。
 * 请写一个函数来判断该数字是否是中心对称数，其输入将会以一个字符串的形式来表达数字。
 * <p>
 * Example
 * Example 1:
 * Input: num = "69"
 * Output: true
 * Example 2:
 * Input: num = "88"
 * Output: true
 * Example 3:
 * Input: num = "962"
 * Output: false
 * Example 4:
 * Input: num = "1"
 * Output: true
 */
public class Solution246 {
    public boolean isStrobogrammatic(String num) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char character : num.toCharArray()) {
            if (character == '0' || character == '1' || character == '2' || character == '5' || character == '8')
                stringBuilder.append(character);
            else if (character == '6')
                stringBuilder.append('9');
            else if (character == '9')
                stringBuilder.append('6');
            else
                return false;
        }
        return stringBuilder.toString().equals(num);
    }

    public boolean isStrobogrammatic1(String num) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put('0', '0');
        map.put('1', '1');
        map.put('6', '9');
        map.put('8', '8');
        map.put('9', '6');
        int left = 0, right = num.length() - 1;
        while (left < right) {
            char leftChar = num.charAt(left);
            char rightChar = num.charAt(right);
            if (!map.containsKey(leftChar) || !map.containsKey(rightChar))
                return false;
            if (map.get(leftChar) != map.get(rightChar))
                return false;
            left++;
            right--;
        }
        return true;
    }
}
