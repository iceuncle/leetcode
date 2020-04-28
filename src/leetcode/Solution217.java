package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * <p>存在重复元素
 * Created by tianyang on 2018/11/8.
 */
public class Solution217 {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            } else {
                set.add(nums[i]);
            }
        }
        return false;
    }

    public boolean containsDuplicate1(int[] nums) {
        if (nums.length == 0) return false;
        Arrays.sort(nums);
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if ((res ^ nums[i]) == 0) {
                return true;
            }
            res = nums[i];
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
