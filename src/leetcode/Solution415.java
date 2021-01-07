package leetcode;

public class Solution415 {

    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
        StringBuilder res = new StringBuilder();
        while (i >= 0 || j >= 0 || carry != 0) {
            int a = i >= 0 ? num1.charAt(i) - '0' : 0;
            int b = j >= 0 ? num2.charAt(j) - '0' : 0;
            int sum = a + b + carry;
            res.append(sum % 10);
            carry = sum / 10;
            i--;
            j--;
        }
        return res.reverse().toString();
    }

}
