package 算法中极.其它;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class 逆波兰表达式求值 {

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

    public static void main(String[] args) {
        System.out.println(new 逆波兰表达式求值().evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }

}
