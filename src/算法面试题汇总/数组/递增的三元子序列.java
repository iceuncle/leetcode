package 算法面试题汇总.数组;

/**
 * <p>
 * Created by tianyang on 2020/3/12.
 */
public class 递增的三元子序列 {

    public boolean increasingTriplet(int[] nums) {
        int small = Integer.MAX_VALUE, mid = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= small)
                small = nums[i];
            else if (nums[i] <= mid)
                mid = nums[i];
            else
                return true;
        }
        return false;
    }

}
