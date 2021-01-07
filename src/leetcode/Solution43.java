package leetcode;

public class Solution43 {

    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        String res = "0";
        int m = num1.length(), n = num2.length();
        for (int i = n - 1; i >= 0; i--) {
            int b = num2.charAt(i) - '0';
            int carry = 0;
            StringBuilder builder = new StringBuilder();
            for (int j = n - 1; j > i; j--) {
                builder.append(0);
            }
            for (int j = m - 1; j >= 0; j--) {
                int a = num1.charAt(j) - '0';
                int multi = a * b + carry;
                builder.append(multi % 10);
                carry = multi / 10;
            }
            if (carry > 0)
                builder.append(carry);
            res = add(res, builder.reverse().toString());
        }
        return res;
    }

    public String add(String num1, String num2) {
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
