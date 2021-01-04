package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Solution90 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        backTracking(nums, 0, new Stack<>(), res);
        return res;
    }


    public void backTracking(int[] nums, int index, Stack<Integer> path, List<List<Integer>> res) {
        res.add(new ArrayList<>(path));
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1])
                continue;
            path.add(nums[i]);
            backTracking(nums, i + 1, path, res);
            path.pop();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution90().subsetsWithDup(new int[]{1, 2, 2}));
    }

}
