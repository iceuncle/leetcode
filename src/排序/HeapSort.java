package 排序;

import java.util.Arrays;

public class HeapSort {

    public void sort(int[] nums) {
        for (int i = parent(nums.length - 1); i >= 0; i--) {
            siftDown(nums, i, nums.length);
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;
            siftDown(nums, 0, i);
        }
    }

    public int parent(int index) {
        return (index - 1) / 2;
    }

    public int leftChild(int index) {
        return index * 2 + 1;
    }

    public void siftDown(int[] nums, int i, int length) {
        while (leftChild(i) < length) {
            int j = leftChild(i);
            if (j + 1 < length && nums[j] < nums[j + 1])
                j++;
            if (nums[i] > nums[j])
                break;
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i = j;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 9, 0, 2, 4};
        new HeapSort().sort(arr);
        System.out.println(Arrays.toString(arr));
    }

}

