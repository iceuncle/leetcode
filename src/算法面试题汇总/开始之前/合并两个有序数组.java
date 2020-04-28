package 算法面试题汇总.开始之前;

/**
 * <p>
 * Created by tianyang on 2020/3/12.
 */
public class 合并两个有序数组 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int len = m + n - 1;
        int len1 = m - 1;
        int len2 = n - 1;
        while (len2 >= 0) {
            if (len1 < 0 || nums2[len2] >= nums1[len1]) {
                nums1[len--] = nums2[len2--];
            } else {
                nums1[len--] = nums1[len1--];
            }
        }
    }
}
