package leetcode;

import java.util.Arrays;

public class Solution58 {

    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) return 0;
        String[] strs = s.trim().split(" ");
        return strs.length > 0 ? strs[strs.length - 1].length() : 0;
    }

    public int lengthOfLastWord1(String s) {
        if (s == null || s.length() == 0) return 0;
        int end = s.length() - 1;
        while (end >= 0 && s.charAt(end) == ' ')
            end--;
        if (end < 0) return 0;
        int start = end;
        while (start >= 0 && s.charAt(start) != ' ')
            start--;
        return end - start;
    }


    public static void main(String[] args) {
        System.out.println(" a   aa   ");
        System.out.println(" a   aa   ".trim());
        System.out.println(Arrays.toString(" ".split(" ")));
    }
}
