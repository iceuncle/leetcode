package leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 逆波兰表达式求值
 */
public class Solution150 {

    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();
        for (String token : tokens) {
            switch (token) {
                case "+": {
                    int a = stack.pollLast();
                    int b = stack.pollLast();
                    stack.addLast(a + b);
                    break;
                }
                case "-": {
                    int a = stack.pollLast();
                    int b = stack.pollLast();
                    stack.addLast(b - a);
                    break;
                }
                case "*": {
                    int a = stack.pollLast();
                    int b = stack.pollLast();
                    stack.addLast(a * b);
                    break;
                }
                case "/": {
                    int a = stack.pollLast();
                    int b = stack.pollLast();
                    stack.addLast(b / a);
                    break;
                }
                default:
                    stack.addLast(Integer.valueOf(token));
                    break;
            }
        }
        return stack.pollLast();
    }

}
