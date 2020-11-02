package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution15 {

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

}
