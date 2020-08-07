package leetcode;

import java.util.Arrays;

/**
 * <p>合并两个有序数组
 * Created by tianyang on 2018/11/7.
 * <p>
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * <p>
 * 说明:
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 示例:
 * <p>
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * 输出: [1,2,2,3,5,6]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m - 1;
        int index2 = n - 1;
        while (index2 >= 0) {
            if (index1 < 0) {
                for (int i = 0; i <= index2; i++) {
                    nums1[i] = nums2[i];
                }
                break;
            }
            if (nums2[index2] >= nums1[index1]) {
                nums1[index1 + index2 + 1] = nums2[index2];
                index2--;
            } else {
                nums1[index1 + index2 + 1] = nums1[index1];
                index1--;
            }
        }
    }

    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int len = m + n - 1;
        int lenA = m - 1;
        int lenB = n - 1;
        while (lenA >= 0 && lenB >= 0) {
            if (nums1[lenA] > nums2[lenB]) {
                nums1[len--] = nums1[lenA--];
            } else {
                nums1[len--] = nums1[lenB--];
            }
        }
        while (lenB >= 0) {
            nums1[len--] = nums2[lenB--];
        }
    }

    //1 0 2  -1
    public static void main(String[] args) {
        int[] nums1 = new int[]{2, 0};
        int[] nums2 = new int[]{1};
        (new Solution88()).merge(nums1, 0, nums2, 1);
        System.out.println(Arrays.toString(nums1));
    }
}
