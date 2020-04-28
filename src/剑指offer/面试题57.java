package 剑指offer;

import java.util.HashMap;
import java.util.HashSet;

/**
 * <p>
 * Created by tianyang on 2020/3/17.
 * 和为s的两个数字
 */
public class 面试题57 {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i]))
                return new int[]{nums[i], target - nums[i]};
            map.put(nums[i], i);
        }
        return null;
    }

    public int[] twoSum1(int[] nums, int target) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(target-nums[i]))
                return new int[]{nums[i], target-nums[i]};
            set.add(nums[i]);
        }
        return null;
    }

}
