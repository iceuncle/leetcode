package 排序;

import java.util.Arrays;

public class QuickSort {

    public void sort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    public void quickSort(int[] nums, int l, int r) {
        if (l >= r) return;
        int p = partition(nums, l, r);
        quickSort(nums, l, p - 1);
        quickSort(nums, p + 1, r);
    }

    private int partition(int[] nums, int l, int r) {
        swap(nums, l, (int) (Math.random() * (r - l + 1)) + l);
        int temp = nums[l];
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (nums[i] < temp) {
                swap(nums, i, j + 1);
                j++;
            }
        }
        swap(nums, l, j);
        return j;
    }

    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 9, 0, 2, 4};
        new QuickSort().sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
