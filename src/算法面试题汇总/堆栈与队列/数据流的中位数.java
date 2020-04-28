package 算法面试题汇总.堆栈与队列;

import java.util.*;

/**
 * <p>
 * Created by tianyang on 2020/3/13.
 * <p>
 * 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
 * <p>
 * 例如，
 * <p>
 * [2,3,4] 的中位数是 3
 * <p>
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 * <p>
 * 设计一个支持以下两种操作的数据结构：
 * <p>
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 * 示例：
 * <p>
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3)
 * findMedian() -> 2
 * 进阶:
 * <p>
 * 如果数据流中所有整数都在 0 到 100 范围内，你将如何优化你的算法？
 * 如果数据流中 99% 的整数都在 0 到 100 范围内，你将如何优化你的算法？
 */
public class 数据流的中位数 {

    class MedianFinder {
        private PriorityQueue<Integer> maxHeap;
        private PriorityQueue<Integer> minHeap;
        int count = 0;

        /**
         * initialize your data structure here.
         */
        public MedianFinder() {
            maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
            minHeap = new PriorityQueue<>();
        }

        public void addNum(int num) {
            count++;
            maxHeap.add(num);
            minHeap.add(maxHeap.poll());
            if ((count & 1) == 1) {
                maxHeap.add(minHeap.poll());
            }
        }

        public double findMedian() {
            if ((count & 1) == 0)
                return (double) (maxHeap.peek() + minHeap.peek()) / 2;
            else
                return maxHeap.peek();
        }
    }


    static class MedianFinder1 {
        private List<Integer> list;

        public MedianFinder1() {
            list = new ArrayList<>();
        }

        public void addNum(int num) {
            list.add(num);
        }

        public double findMedian() {
            Collections.sort(list);
            int size = list.size();
            return size % 2 == 0 ? (list.get(size / 2 - 1) + list.get(size / 2)) / (double) 2
                    : list.get(size / 2);
        }
    }

    public static void main(String[] args) {
        MedianFinder1 obj = new MedianFinder1();
        obj.addNum(1);

        double param_2 = obj.findMedian();
        System.out.println(param_2);
    }
}
