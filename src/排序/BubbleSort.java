package 排序;

import java.util.Arrays;

public class BubbleSort {

    public static void sort(int[] nums) {
        boolean hasChange = true;
        for (int i = 0; i < nums.length && hasChange; i++) {
            hasChange = false;
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    hasChange = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 9, 0, 2, 4};
        BubbleSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
