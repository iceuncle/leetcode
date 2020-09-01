package leetcode;

import java.util.Arrays;

/**
 * 使数组唯一的最小增量
 */
public class Solution945 {

    //3,2,1,2,1,7
    ///123237
    // 1 2
    public int minIncrementForUnique(int[] A) {
        Arrays.sort(A);
        int res = 0;
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] >= A[i + 1]) {
                res += A[i] - A[i + 1] + 1;
                A[i + 1] = A[i] + 1;
            }
        }
        return res;
    }

    public int minIncrementForUnique1(int[] A) {
        int[] count = new int[40000];
        int max = 0;
        for (int index : A) {
            count[index]++;
            max = Math.max(max, index);
        }
        int res = 0;
        for (int i = 0; i < max; i++) {
            if (count[i] > 1) {
                res += count[i] - 1;
                count[i + 1] += count[i] - 1;
            }
        }
        if (count[max] > 1) {
            int n = count[max] - 1;
            res += (1 + n) * n / 2;
        }
        return res;
    }
}
