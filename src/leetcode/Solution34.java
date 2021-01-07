package leetcode;

import java.util.Arrays;

public class Solution34 {

    public int binarySearch(int[] nums, int target, boolean isLeft) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target || (isLeft && nums[mid] == target)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return new int[]{-1, -1};
        int leftIndex = binarySearch(nums, target, true);
        if (leftIndex == nums.length || nums[leftIndex] != target)
            return new int[]{-1, -1};
        int rightIndex = binarySearch(nums, target, false);
        return new int[]{leftIndex, rightIndex - 1};
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution34().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 4)));
    }


}
