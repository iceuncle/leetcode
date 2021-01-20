package 排序;

import java.util.Arrays;

public class InsertSort {

    public static void sort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i];
            int j = i;
            while (j > 0 && temp < nums[j - 1]) {
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 9, 0, 2, 4};
        InsertSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
