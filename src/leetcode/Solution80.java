package leetcode;

public class Solution80 {

    /**
     * 输入：nums = [0,0,1,1,1,1,2,3,3]
     * 输出：7, nums = [0,0,1,1,2,3,3]
     */
    public int removeDuplicates(int[] nums) {
        int count = 1;
        int j = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                count++;
            } else {
                count = 1;
            }
            if (count <= 2)
                nums[j++] = nums[i];
        }
        return j;
    }


    public static void main(String[] args) {
        System.out.println(new Solution80().removeDuplicates(new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3}));
    }

}
