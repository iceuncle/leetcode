package leetcode;

import java.util.Arrays;

public class Solution16 {

    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3)
            throw new IllegalArgumentException("nums cannot be empty");
        Arrays.sort(nums);
        int res = 0, gap = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (Math.abs(sum - target) < gap) {
                    res = sum;
                    gap = Math.abs(sum - target);
                }
                if (sum == target) {
                    return target;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution16().threeSumClosest(new int[]{1, 1, 1, 0}, -100));
    }
}
