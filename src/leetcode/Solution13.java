package leetcode;

/**
 * <p>罗马数字转整数
 * Created by tianyang on 2018/11/8.
 */
public class Solution13 {

    public int romanToInt(String s) {
        if (s == null || s.length() == 0) return 0;
        int sum = 0;
        int prev = getValue(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int curr = getValue(s.charAt(i));
            if (curr > prev)
                sum -= prev;
            else
                sum += prev;
            prev = curr;
        }
        sum += prev;
        return sum;
    }

    public int getValue(char ch) {
        switch (ch) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution13().romanToInt("CLXLV"));
    }

}
