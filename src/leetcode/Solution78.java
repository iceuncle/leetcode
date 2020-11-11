package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 子集 回溯
 */
public class Solution78 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for (int num : nums) {
            List<List<Integer>> arrayList = new ArrayList<>();
            for (List<Integer> resList : res) {
                List<Integer> list = new ArrayList<>(resList);
                list.add(num);
                arrayList.add(list);
            }
            res.addAll(arrayList);
        }
        return res;
    }

    public List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        Stack<Integer> stack = new Stack<>();
        backTracking(nums, 0, stack, res);
        return res;
    }

    public void backTracking(int[] nums, int index, Stack<Integer> path, List<List<Integer>> res) {
        res.add(new ArrayList<>(path));
        for (int i = index; i < nums.length; i++) {
            path.add(nums[i]);
            backTracking(nums, i + 1, path, res);
            path.pop();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution78().subsets1(new int[]{1, 2, 3}));
    }

}
