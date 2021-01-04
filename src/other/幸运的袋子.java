package other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class 幸运的袋子 {

    public int solution(int n, int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backTracking(nums, 0, new Stack<>(), res);
        return res.size();
    }

    private void backTracking(int[] nums, int index, Stack<Integer> path, List<List<Integer>> res) {
        if (isValidPath(path)) {
            res.add(new ArrayList<>(path));
        }
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1])
                continue;
            path.add(nums[i]);
            backTracking(nums, i + 1, path, res);
            path.pop();
        }
    }

    private boolean isValidPath(Stack<Integer> path) {
        int sum = 0, product = 1;
        for (Integer num : path) {
            sum += num;
            product *= num;
        }
        return sum > product;
    }

    public static void main(String[] args) {
        System.out.println(new 幸运的袋子().solution(3, new int[]{1, 1, 1}));
    }

}
