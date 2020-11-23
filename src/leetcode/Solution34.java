package leetcode;

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
        int leftIndex = binarySearch(nums, target, true);
        if (leftIndex == nums.length || nums[leftIndex] != target)
            return new int[]{-1, -1};
        int rightIndex = binarySearch(nums, target, false);
        return new int[]{leftIndex, rightIndex - 1};
    }

}
