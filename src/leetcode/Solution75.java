package leetcode;

public class Solution75 {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0)
            return;
        int left = 0, right = nums.length - 1, i = 0;
        while (i <= right) {
            if (nums[i] == 0) {
                nums[i] = nums[left];
                nums[left] = 0;
                left++;
            }
            if (nums[i] == 2) {
                nums[i] = nums[right];
                nums[right] = 2;
                right--;
                continue;
            }
            i++;
        }
    }
}
