package 算法中极.排序与搜素;

import java.util.Arrays;

/**
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,1,0,1,2,2]
 */
public class 颜色分类 {

    public void sortColors(int[] nums) {
        int p = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[i] = nums[p];
                nums[p++] = 0;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                nums[i] = nums[p];
                nums[p++] = 1;
            }
        }
    }

    public void sortColors1(int[] nums) {
        int p0 = 0, p1 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                nums[i] = nums[p1];
                nums[p1++] = 1;
            } else if (nums[i] == 0) {
                nums[i] = nums[p0];
                nums[p0] = 0;
                if (p0 < p1) {
                    nums[i] = nums[p1];
                    nums[p1] = 1;
                }
                p0++;
                p1++;
            }
        }
    }

    public void sortColors2(int[] nums) {
        int p0 = 0, p2 = nums.length - 1;
        for (int i = 0; i <= p2; i++) {
            while (nums[i] == 2 && i <= p2) {
                nums[i] = nums[p2];
                nums[p2--] = 2;
            }
            if (nums[i] == 0) {
                nums[i] = nums[p0];
                nums[p0++] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 0, 2, 1, 1, 0};
        new 颜色分类().sortColors1(nums);
        System.out.println(Arrays.toString(nums));
    }

}
