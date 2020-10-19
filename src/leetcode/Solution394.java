package leetcode;

import java.util.Collections;
import java.util.Stack;

public class Solution394 {

    public int index = 0;

    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        while (index < s.length()) {
            char character = s.charAt(index);
            if (Character.isDigit(character)) {
                stack.push(getDigits(s));
            } else if (Character.isLetter(character) || character == '[') {
                stack.push(String.valueOf(character));
                index++;
            } else {
                Stack<String> sub = new Stack<>();
                while (!stack.peek().equals("[")) {
                    sub.push(stack.pop());
                }
                stack.pop();
                StringBuilder subString = new StringBuilder();
                while (!sub.isEmpty()) {
                    subString.append(sub.pop());
                }
                Integer count = Integer.valueOf(stack.pop());
                StringBuilder stringBuilder = new StringBuilder();
                while (count > 0) {
                    stringBuilder.append(subString.toString());
                    count--;
                }
                stack.push(stringBuilder.toString());
                index++;
            }
        }

        Collections.reverse(stack);
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }
        return res.toString();
    }

    public String getDigits(String s) {
        StringBuilder res = new StringBuilder();
        while (Character.isDigit(s.charAt(index))) {
            res.append(s.charAt(index));
            index++;
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution394().decodeString("3[a2[cb]]"));
        System.out.println(new Solution394().decodeString("3[a]2[cb]"));
    }

}
