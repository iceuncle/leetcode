package leetcode;

public class Solution27 {

    public int removeElement(int[] nums, int val) {
        if (nums == null)
            throw new IllegalArgumentException("nums cannot be null");
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j++] = nums[i];
            }
        }
        return j;
    }

    public static void main(String[] args) {
        System.out.println(new Solution27().removeElement(new int[]{}, 0));
    }
}
