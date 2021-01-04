package leetcode;

import java.util.*;

/**
 * 全排列 II 回溯
 */
public class Solution47 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return res;
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        backTracking(nums, 0, new ArrayDeque<>(), res, used);
        return res;
    }

    private void backTracking(int[] nums, int index, Deque<Integer> path, List<List<Integer>> res, boolean[] used) {
        if (index == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i-1]))
                continue;
            path.addLast(nums[i]);
            used[i] = true;
            backTracking(nums, index + 1, path, res, used);
            path.removeLast();
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution47().permuteUnique(new int[]{1, 2, 3}));
    }

}
