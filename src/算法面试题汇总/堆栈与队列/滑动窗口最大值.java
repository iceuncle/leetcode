package 算法面试题汇总.堆栈与队列;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <p>
 * Created by tianyang on 2020/3/13.
 */
public class 滑动窗口最大值 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0)
            return new int[0];
        int n = nums.length;
        int[] output = new int[n - k + 1];
        for (int i = 0; i < n - k + 1; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j < i + k; j++)
                max = Math.max(max, nums[j]);
            output[i] = max;
        }
        return output;
    }

    public int[] maxSlidingWindow1(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) return new int[0];
        Deque<Integer> deque = new ArrayDeque<>();
        int len = nums.length - k + 1;
        int[] res = new int[len];
        for (int i = 0; i < nums.length; i++) {
            if (!deque.isEmpty() && i - k == deque.getFirst())
                deque.removeFirst();
            helper(deque, nums, i);
            if (i - k + 1 >= 0) {
                res[i - k + 1] = nums[deque.getFirst()];
            }
        }
        return res;
    }

    public void helper(Deque<Integer> deque, int[] nums, int i) {
        while (!deque.isEmpty() && nums[deque.getLast()] < nums[i]) {
            deque.removeLast();
        }
        deque.addLast(i);
    }
}
