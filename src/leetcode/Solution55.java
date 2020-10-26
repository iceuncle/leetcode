package leetcode;

public class Solution55 {

    /**
     * 输入: [2,3,1,1,4]
     * 2 4
     * 3 2
     *
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i <= max) {
                max = Math.max(max, nums[i] + i);
                if (max >= nums.length - 1)
                    return true;
            }
        }
        return false;
    }

}
