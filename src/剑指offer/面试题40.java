package 剑指offer;

import java.util.PriorityQueue;

/**
 * <p>
 * Created by tianyang on 2020/3/17.
 * 最小的k个数
 */
public class 面试题40 {

    public int[] getLeastNumbers(int[] arr, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int num : arr) {
            queue.add(num);
            if (queue.size() > k)
                queue.poll();
        }
        int[] res = new int[k];
        int index = 0;
        while (!queue.isEmpty()) {
            res[index++] = queue.poll();
        }
        return res;
    }

}
