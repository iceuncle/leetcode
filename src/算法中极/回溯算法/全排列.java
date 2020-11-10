package 算法中极.回溯算法;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 全排列 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return res;
        Stack<Integer> stack = new Stack<>();
        backTracking(nums, 0, stack, res);
        return res;
    }

    public void backTracking(int[] nums, int index, Stack<Integer> stack, List<List<Integer>> res) {
        if (index == nums.length) {
            res.add(new ArrayList<>(stack));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!stack.contains(nums[i])) {
                stack.push(nums[i]);
                backTracking(nums, index + 1, stack, res);
                stack.pop();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new 全排列().permute(new int[]{1, 2, 3}));
    }

}
