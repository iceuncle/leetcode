package 算法中极.排序与搜素;

import java.util.Arrays;

public class 在排序数组中查找元素的第一个和最后一个位置 {


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

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new 在排序数组中查找元素的第一个和最后一个位置()
                .searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
    }

}
