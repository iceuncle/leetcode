package 剑指offer;

/**
 * <p>
 * Created by tianyang on 2020/3/17.
 * 在排序数组中查找数字 I
 */
public class 面试题53I {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int count = 0;
        while (left <= right) {
            if (left == right) {
                if (nums[left] == nums[right] && nums[left] == target)
                    count++;
            } else {
                if (nums[left] == target)
                    count++;
                if (nums[right] == target)
                    count++;
            }
            left++;
            right--;
        }
        return count;
    }
}
