package 算法面试题汇总.排序与检索;

import java.util.Arrays;
import java.util.HashSet;

/**
 * <p>
 * Created by tianyang on 2020/3/16.
 */
public class 寻找重复数 {

    public int findDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num))
                return num;
            set.add(num);
        }
        return -1;
    }

    public int findDuplicate1(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1])
                return nums[i];
        }
        return -1;
    }

}
