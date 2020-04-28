package 算法初级.排序和搜索;

/**
 * <p>
 * Created by tianyang on 2020/3/10.
 * <p>
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 num1 成为一个有序数组。
 * <p>
 * <p>
 * <p>
 * 说明:
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * 输出: [1,2,2,3,5,6]
 */
public class 合并两个有序数组 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int len = m + n - 1;
        int len1 = m - 1;
        int len2 = n - 1;
        while (len2 > 0) {
            if (len1 < 0 || nums2[len2] >= nums1[len1]) {
                nums1[len--] = nums2[len2--];
            } else {
                nums1[len--] = nums1[len1--];
            }
        }
    }

}
