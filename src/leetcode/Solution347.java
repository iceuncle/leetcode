package leetcode;

import java.util.*;

/**
 * <p>
 * Created by tianyang on 2020/3/11.
 * 前 K 个高频元素
 */
public class Solution347 {

    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>((o1, o2) -> map.get(o1) - map.get(o2));
        for (int key : map.keySet()) {
            heap.add(key);
            if (heap.size() > k)
                heap.poll();
        }
        List<Integer> list = new ArrayList<>();
        while (!heap.isEmpty())
            list.add(heap.poll());
        return list;
    }


    public static void main(String[] args) {
        System.out.println((new Solution347()).topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2));
    }

}
