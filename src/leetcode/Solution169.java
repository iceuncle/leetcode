package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>求众数  摩尔投票法
 * Created by tianyang on 2018/11/8.
 */
public class Solution169 {
    public int majorityElement(int[] nums) {
        int res = nums[0], count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                res = nums[i];
                count++;
                continue;
            }
            if (nums[i] == res) {
                count++;
            } else {
                count--;
            }
        }
        return res;
    }

    public int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public int majorityElement2(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
                if (map.get(nums[i]) > nums.length / 2) {
                    return nums[i];
                }
            } else {
                map.put(nums[i], 1);
            }
        }
        throw new IllegalArgumentException("No Solution1");
    }

    public int majorityElement3(int[] nums) {
        return find(nums, 0, nums.length - 1);
    }

    public int find(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }
        int mid = (left + right) / 2;
        int leftRes = find(nums, left, mid);
        int rightRes = find(nums, mid + 1, right);
        if (leftRes == rightRes) {
            return leftRes;
        } else {
            int countLeft = 0, countRight = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == leftRes) {
                    countLeft++;
                } else if (nums[i] == rightRes) {
                    countRight++;
                }
            }
            return countLeft > countRight ? leftRes : rightRes;
        }
    }

    public static void main(String[] args) {
        System.out.println((new Solution169()).majorityElement(new int[]{3, 2, 3}));
        System.out.println((new Solution169()).majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }

}
