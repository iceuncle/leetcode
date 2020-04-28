package leetcode;

import java.util.Stack;

/**
 * <p>最小栈
 * Created by tianyang on 2018/11/8.
 */
public class Solution155 {

    class MinStack {
        private Stack<Integer> stack1 = new Stack<>();
        private Stack<Integer> stack2 = new Stack<>();
        private int size = 0;

        public MinStack() {

        }

        public void push(int x) {
            size++;
            stack1.push(x);
            if (stack2.isEmpty() || x <= stack2.peek()) {
                stack2.push(x);
            }
        }

        public void pop() {
            if (size <= 0) {
                return;
            }
            size--;
            if ((int) stack1.peek() == (int) stack2.peek()) {
                stack2.pop();
            }
            stack1.pop();
        }

        public int top() {
            if (size <= 0) {
                throw new IllegalArgumentException("Empty Exception");
            }
            return stack1.peek();
        }

        public int getMin() {
            if (size <= 0) {
                throw new IllegalArgumentException("Empty Exception");
            }
            return stack2.peek();
        }
    }

    public void test() {
        MinStack minStack = new MinStack();
        minStack.push(0);
        minStack.push(1);
        minStack.push(0);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }

    public static void main(String[] args) {
        (new Solution155()).test();
    }
}
