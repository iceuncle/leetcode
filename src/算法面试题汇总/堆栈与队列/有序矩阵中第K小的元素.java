package 算法面试题汇总.堆栈与队列;

import java.util.PriorityQueue;

/**
 * <p>
 * Created by tianyang on 2020/3/13.
 */
public class 有序矩阵中第K小的元素 {

    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(((o1, o2) -> o2 - o1));
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                heap.add(matrix[i][j]);
                if (heap.size() > k)
                    heap.poll();
            }
        }
        return heap.peek();
    }

    public int kthSmallest1(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];
        while (left != right) {
            int mid = (left + right) / 2;
            if (check(matrix, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean check(int[][] matrix, int k, int num) {
        int n = matrix.length;
        int i = n - 1;
        int j = 0;
        int count = 0;
        while (i >= 0 && j <= n - 1) {
            if (matrix[i][j] <= num) {
                count += i + 1;
                j++;
            } else {
                i--;
            }
        }
        return count >= k;
    }
}
