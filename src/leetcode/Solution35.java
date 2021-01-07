package leetcode;

public class Solution35 {

    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        //0 3 0 left
        System.out.println(new Solution35().searchInsert(new int[]{1, 3, 5, 5, 5, 6}, 5));
    }

}
