package 算法面试题汇总.哈希与映射;

import java.util.HashMap;

/**
 * <p>
 * Created by tianyang on 2020/3/16.
 */
public class 四数相加II {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int sum = A[i] + B[j];
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        int count = 0;
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                int sum = C[i] + D[j];
                count += map.getOrDefault(0 - sum, 0);
            }
        }
        return count;
    }
}
