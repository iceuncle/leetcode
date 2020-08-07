package 剑指offer;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <p>
 * Created by tianyang on 2020/3/17.
 * 滑动窗口的最大值
 * <p>
 * <p>
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 * <p>
 * 示例:
 * <p>
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 * <p>
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 */
public class 面试题59I {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0){
            return new int[0];
        }
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length - k + 1; i++) {
            int max = nums[i];
            for (int j = i + 1; j < i + k; j++) {
                max = Math.max(max, nums[j]);
            }
            res[i] = max;
        }
        return res;
    }

    public int[] maxSlidingWindow1(int[] nums, int k) {
        int len = nums.length - k + 1;
        int[] resArr = new int[len];
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            if (!queue.isEmpty() && queue.getFirst() == i - k)
                queue.removeFirst();
            offer(queue, nums, i);
            if (i >= k - 1)
                resArr[i - k + 1] = nums[queue.getFirst()];
        }
        return resArr;
    }

    public void offer(Deque<Integer> queue, int[] nums, int i) {
        while (!queue.isEmpty() && nums[queue.getLast()] < nums[i])
            queue.removeLast();
        queue.addLast(i);
    }

}
