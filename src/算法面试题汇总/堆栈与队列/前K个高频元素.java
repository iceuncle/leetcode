package 算法面试题汇总.堆栈与队列;

import java.util.*;

/**
 * <p>
 * Created by tianyang on 2020/3/13.
 * <p>
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 * <p>
 * 输入: nums = [1], k = 1
 * 输出: [1]
 */
public class 前K个高频元素 {

    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> hashMap.get(o1) - hashMap.get(o2));
        for (int key : hashMap.keySet()) {
            heap.add(key);
            if (heap.size() > k)
                heap.poll();
        }
        List<Integer> ret = new ArrayList<>();
        while (!heap.isEmpty())
            ret.add(heap.poll());
        return ret;
    }


}
