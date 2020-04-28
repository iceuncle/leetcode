package 每日一题;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * <p>
 * Created by tianyang on 2020/3/9.
 */
public class 队列的最大值 {

    /**
     * queue 4 2 0 3
     * deque 4 2 0
     * deque 4 3
     */
    class MaxQueue {

        Queue<Integer> queue;
        Deque<Integer> sort_queue;

        public MaxQueue() {
            queue = new LinkedList<>();
            sort_queue = new LinkedList<>();
        }

        public int max_value() {
            if (sort_queue.isEmpty())
                return -1;
            return sort_queue.peekFirst();
        }

        public void push_back(int value) {
            queue.add(value);
            while (sort_queue.size() > 0 && value > sort_queue.getLast())
                sort_queue.removeLast();
            sort_queue.addLast(value);
        }

        public int pop_front() {
            if (queue.isEmpty())
                return -1;
            int ret = queue.poll();
            if (ret == sort_queue.getFirst())
                sort_queue.removeFirst();
            return ret;
        }
    }

}
