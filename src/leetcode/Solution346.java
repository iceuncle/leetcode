package leetcode;

/**
 * 数据流中的移动平均值
 * 给定一个整数数据流和一个窗口大小，根据该滑动窗口的大小，计算其所有整数的移动平均值。
 * <p>
 * Example:
 * MovingAverage m = new MovingAverage(3);
 * m.next(1) = 1
 * m.next(10) = (1 + 10) / 2
 * m.next(3) = (1 + 10 + 3) / 3
 * m.next(5) = (10 + 3 + 5) / 3
 */
public class Solution346 {

    class MovingAverage {
        //队列大小
        int size;
        //队列开始位置
        int head = 0;
        //对应区间和
        int sum = 0;
        //当前统计数量
        int count = 0;
        //循环队列
        int[] queue;

        public MovingAverage(int size) {
            this.size = size;
            //初始化循环队列
            queue = new int[size];
        }

        //T O(1)
        //S O(n)
        public double next(int val) {
            count++;
            int tail = (head + 1) % size;
            sum = sum - queue[tail] + val;
            queue[tail] = val;
            head = tail;
            return sum * 1.0 / Math.min(count, size);
        }
    }

}
