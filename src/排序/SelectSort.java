package 排序;

import java.util.Arrays;

public class SelectSort {

    public static void sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 9, 0, 2, 4};
        InsertSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
