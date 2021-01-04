package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 组合总和 回溯
 */
public class Solution39 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0)
            return res;
        backTracking(candidates, target, 0, new ArrayDeque<>(), res);
        return res;
    }


    private void backTracking(int[] candidates, int target, int begin,
                              Deque<Integer> path, List<List<Integer>> res) {
        if (target < 0)
            return;
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < candidates.length; i++) {
            path.addLast(candidates[i]);
            backTracking(candidates, target - candidates[i], i, path, res);
            path.removeLast();
        }
    }



    public static void main(String[] args) {
        System.out.println(new Solution39().combinationSum(new int[]{2, 3, 6, 7}, 7));

    }

}
