package 剑指offer;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * <p>
 * Created by tianyang on 2020/3/16.
 * 链表中倒数第k个节点
 */
public class 面试题22 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public ListNode getKthFromEnd(ListNode head, int k) {
        Deque<ListNode> stack = new ArrayDeque<>();
        while (head != null) {
            stack.addLast(head);
            head = head.next;
        }
        ListNode res = null;
        for (int i = 0; i < k; i++)
            res = stack.pollLast();
        return res;
    }

    public ListNode getKthFromEnd1(ListNode head, int k) {
        ListNode fast = head;
        while (k > 0) {
            fast = fast.next;
            k--;
        }
        ListNode slow = head;
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }


}

