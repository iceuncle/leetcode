package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * <p>
 * Created by tianyang on 2020/3/11.
 * 15. 数组中的第K个最大元素
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 * <p>
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 */
public class Solution215 {

    /**
     * 堆
     */
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int num : nums) {
            heap.add(num);
            if (heap.size() > k)
                heap.poll();
        }
        return heap.peek();
    }

    /**
     * 冒泡
     */
    public int findKthLargest1(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                }
            }
        }
        return nums[k - 1];
    }


    /**
     * 快排
     */
    public int findKthLargest2(int[] nums, int k) {
        return quickSort(nums, 0, nums.length - 1, k - 1);
    }

    public int quickSort(int[] nums, int l, int r, int k) {
        System.out.println("l " + l + "  ;r " + r);
        int p = partition(nums, l, r);
        if (p == k) return nums[p];
        else if (p > k) {
            return quickSort(nums, l, p - 1, k);
        } else {
            return quickSort(nums, p + 1, r, k);
        }
    }

    private int partition(int[] nums, int l, int r) {
        swap(nums, l, new Random().nextInt(r - l + 1) + l);
        int tmp = nums[l];
        int index = l;
        for (int i = l + 1; i <= r; i++) {
            if (nums[i] > tmp) {
                swap(nums, i, ++index);
            }
        }
        swap(nums, l, index);
        return index;
    }

    public void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    /**
     * 堆排序
     */
    public int findKthLargest3(int[] nums, int k) {
        for (int i = parent(nums.length - 1); i >= 0; i--) {
            siftDown(nums, i, nums.length);
        }
        for (int i = nums.length - 1; i >= nums.length - k; i--) {
            int tmp = nums[0];
            nums[0] = nums[i];
            nums[i] = tmp;
            siftDown(nums, 0, i);
        }
        return nums[nums.length - k];
    }

    public void siftDown(int[] nums, int i, int length) {
        while (leftChild(i) < length) {
            int j = leftChild(i);
            if (j + 1 < length && nums[j] < nums[j + 1])
                j++;
            if (nums[i] >= nums[j])
                break;
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i = j;
        }
    }

    public int parent(int i) {
        return (i - 1) / 2;
    }

    public int leftChild(int i) {
        return 2 * i + 1;
    }


    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = (int) (Math.random() * 100);
        }
        int maxK = new Solution215().findKthLargest3(arr, 30);
        System.out.println(maxK);
    }
}
