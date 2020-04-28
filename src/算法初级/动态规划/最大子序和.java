package 算法初级.动态规划;

/**
 * <p>
 * Created by tianyang on 2020/3/10.
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 示例:
 * <p>
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 * <p>
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 */
public class 最大子序和 {

    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int sum[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) sum[i] = nums[0];
            else if (sum[i - 1] + nums[i] > nums[i]) {
                sum[i] = sum[i - 1] + nums[i];
            } else {
                sum[i] = nums[i];
            }
            if (max < sum[i]) max = sum[i];
        }
        return max;
    }


}
