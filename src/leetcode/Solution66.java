package leetcode;

import java.util.Arrays;

public class Solution66 {

    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0)
            return null;
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) return digits;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
