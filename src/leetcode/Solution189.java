package leetcode;

/**
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 * <p>
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 */
public class Solution189 {

    /**
     * 暴力循环
     * 时间复杂度：O(n*k) 。每个元素都被移动 1 步（O(n) k次（O(k)） 。
     * 空间复杂度：O(1)
     */
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k = k % len;
        while (k > 0) {
            int temp = nums[0];
            for (int i = 1; i < len; i++) {
                int cur = nums[i];
                nums[i] = temp;
                temp = cur;
            }
            nums[0] = temp;
            k--;
        }
    }

    public void rotate1(int[] nums, int k) {
        int length = nums.length;
        k = k % length;
        int count = 0;
        for (int start = 0; count < length; start++) {
            int prev = nums[start];
            int cur = start;
            do {
                int next = (cur + k) % length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                cur = next;
                count++;
            } while (cur != start);
        }
    }

    public void rotate2(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

}
