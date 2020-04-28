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
}
