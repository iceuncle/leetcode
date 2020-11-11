package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 全排列 回溯
 * https://leetcode-cn.com/problems/subsets/solution/c-zong-jie-liao-hui-su-wen-ti-lei-xing-dai-ni-gao-/
 */
public class Solution46 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return res;
        Stack<Integer> stack = new Stack<>();
        boolean[] used = new boolean[nums.length];
        backTracking(nums, 0, stack, res, used);
        return res;
    }

    public void backTracking(int[] nums, int index, Stack<Integer> stack, List<List<Integer>> res, boolean[] used) {
        if (index == nums.length) {
            res.add(new ArrayList<>(stack));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                stack.push(nums[i]);
                used[i] = true;
                backTracking(nums, index + 1, stack, res, used);
                stack.pop();
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution46().permute(new int[]{1, 2, 3}));
    }

}
