package 算法中极.数组与字符串;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？
 * 请你找出所有满足条件且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 示例：
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */
public class 三数之和 {

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) return new ArrayList<>();
        int length = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < length; i++) {
            if (nums[i] > 0) continue;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1, right = length - 1;
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1])
                        left++;
                    while (right > left && nums[right] == nums[right - 1])
                        right--;
                    left++;
                    right--;
                } else if (nums[left] + nums[right] + nums[i] > 0)
                    right--;
                else
                    left++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> res = new 三数之和().threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(res);
    }

}
