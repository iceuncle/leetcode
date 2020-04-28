package 算法面试题汇总.开始之前;

import java.util.Arrays;

/**
 * <p>
 * Created by tianyang on 2020/3/12.
 */
public class 多数元素 {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
