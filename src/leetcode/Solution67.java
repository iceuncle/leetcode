package leetcode;

public class Solution67 {

    public String addBinary(String a, String b) {
        int index1 = a.length() - 1, index2 = b.length() - 1;
        int carry = 0;
        StringBuilder res = new StringBuilder();
        while (index1 >= 0 || index2 >= 0 || carry > 0) {
            int num1 = (index1 >= 0) ? a.charAt(index1) - '0' : 0;
            int num2 = (index2 >= 0) ? b.charAt(index2) - '0' : 0;
            int sum = num1 + num2 + carry;
            carry = sum >= 2 ? 1 : 0;
            res.append(sum % 2 == 0 ? '0' : '1');
            index1--;
            index2--;
        }
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution67().addBinary("11", "1"));
    }

}
