package 剑指offer;

/**
 * <p>
 * Created by tianyang on 2020/3/17.
 * 连续子数组的最大和
 */
public class 面试题42 {
    public int maxSubArray(int[] nums) {
        if (nums.length <= 0)
            return 0;
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp = sum[i - 1] + nums[i];
            sum[i] = nums[i] > temp ? nums[i] : temp;
            if (sum[i] > max)
                max = sum[i];
        }
        return max;
    }
}
