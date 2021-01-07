package leetcode;

import java.util.Stack;

public class Solution42 {

    //暴力循环
    public int trap(int[] height) {
        if (height == null || height.length <= 1) return 0;
        int result = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int max_left = 0, max_right = 0;
            for (int j = i; j >= 0; j--) {
                max_left = Math.max(max_left, height[j]);
            }
            for (int j = i; j < height.length; j++) {
                max_right = Math.max(max_right, height[j]);
            }
            System.out.println("i " + i + "  height " + height[i] + "  max_left " + max_left + "  max_right " + max_right);
            result += Math.min(max_left, max_right) - height[i];
        }
        return result;
    }

    //动态规划
    public int trap1(int[] height) {
        if (height == null || height.length <= 1) return 0;
        int result = 0, size = height.length;
        int[] leftMaxArr = new int[size];
        int[] rightMaxArr = new int[size];
        leftMaxArr[0] = height[0];
        for (int i = 1; i < size; i++) {
            leftMaxArr[i] = Math.max(height[i], leftMaxArr[i - 1]);
        }
        rightMaxArr[size - 1] = height[size - 1];
        for (int i = size - 2; i >= 0; i--) {
            rightMaxArr[i] = Math.max(height[i], rightMaxArr[i + 1]);
        }
        for (int i = 1; i < size - 1; i++) {
            result += Math.min(leftMaxArr[i], rightMaxArr[i]) - height[i];
        }
        return result;
    }

    public int trap2(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int pop = stack.pop();
                if (stack.isEmpty()) break;
                int distance = i - stack.peek() - 1;
                int height_diff = Math.min(height[stack.peek()], height[i]) - height[pop];
                result += distance * height_diff;
            }
            stack.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution42().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }


}
