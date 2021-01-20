package 排序;

import java.util.Arrays;

public class MergeSort {

    public void sort(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
    }

    public void mergeSort(int[] nums, int l, int r) {
        if (l >= r) return;
        int mid = (l + r) / 2;
        mergeSort(nums, l, mid);
        mergeSort(nums, mid + 1, r);
        if (nums[mid] > nums[mid + 1])
            merge(nums, l, mid, r);
    }

    private void merge(int[] nums, int l, int mid, int r) {
        int[] temp = new int[r - l + 1];
        int i = l, j = mid + 1, k = 0;
        while (i <= mid && j <= r) {
            if (nums[i] <= nums[j])
                temp[k++] = nums[i++];
            else
                temp[k++] = nums[j++];
        }
        while (i <= mid)
            temp[k++] = nums[i++];
        while (j <= r)
            temp[k++] = nums[j++];
        for (int index = 0; index < temp.length; index++) {
            nums[l + index] = temp[index];
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 9, 0, 2, 4};
        new MergeSort().sort(arr);
        System.out.println(Arrays.toString(arr));
    }


}
