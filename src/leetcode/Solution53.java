package leetcode;

/**
 * <p>最大自序和
 * Created by tianyang on 2018/11/6.
 * <p>
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 示例:
 * <p>
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 * <p>
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution53 {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (max < sum) max = sum;
            }
        }
        return max;
    }

    public int maxSubArray1(int[] nums) {
        if (nums.length == 0) return 0;
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int a = sum[i - 1] + nums[i];
            sum[i] = Math.max(a, nums[i]);
            if (max < sum[i]) max = sum[i];
        }
        return max;
    }


    public static void main(String[] args) {
        System.out.println((new Solution53()).maxSubArray(new int[]{-1, 1}));

        System.out.println((new Solution53()).maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
