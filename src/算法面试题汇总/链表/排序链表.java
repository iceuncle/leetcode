package 算法面试题汇总.链表;

import java.util.PriorityQueue;

/**
 * <p>
 * Created by tianyang on 2020/3/16.
 */
public class 排序链表 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }


    public ListNode sortList(ListNode head) {
        ListNode temp = head;
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        while (temp != null) {
            heap.add(temp.val);
            temp = temp.next;
        }
        temp = head;
        while (!heap.isEmpty()) {
            temp.val = heap.poll();
            temp = temp.next;
        }
        return head;
    }


}
