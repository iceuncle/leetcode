package 算法中极.排序与搜素;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class 前K个高频元素 {

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> map.get(o1) - map.get(o2));
        for (int key : map.keySet()) {
            heap.add(key);
            if (heap.size() > k)
                heap.poll();
        }
        int[] res = new int[k];
        int index = 0;
        while (!heap.isEmpty()) {
            res[index++] = heap.poll();
        }
        return res;
    }

}
