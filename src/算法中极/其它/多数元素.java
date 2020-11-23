package 算法中极.其它;

import java.util.Arrays;

public class 多数元素 {

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public int majorityElement1(int[] nums) {

        int count = 0;
        int res = 0;
        for (int num : nums) {
            if (count == 0) {
                res = num;
                count++;
                continue;
            }
            if (res == num) {
                count++;
            } else
                count--;
        }
        return res;
    }

}
