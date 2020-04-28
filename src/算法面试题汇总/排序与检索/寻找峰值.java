package 算法面试题汇总.排序与检索;

/**
 * <p>
 * Created by tianyang on 2020/3/16.
 */
public class 寻找峰值 {

    public int findPeakElement(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1])
                return i;
        }
        return nums.length - 1;
    }

}
