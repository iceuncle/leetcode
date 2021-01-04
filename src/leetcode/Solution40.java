package leetcode;

import java.util.*;

/**
 * 组合总和 II 回溯
 */
public class Solution40 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0)
            return res;
        Arrays.sort(candidates);
        backTracking(candidates, target, 0, new ArrayDeque<>(), res);
        return res;
    }

    public void backTracking(int[] nums, int target, int begin,
                             Deque<Integer> path, List<List<Integer>> res) {
        if (target < 0) return;
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < nums.length; i++) {
            if (i > begin && nums[i] == nums[i - 1])
                continue;
            path.addLast(nums[i]);
            backTracking(nums, target - nums[i], i + 1, path, res);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution40().combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
    }

}
