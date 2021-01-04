package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution19 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode fast = dummyHead;
        ListNode slow = dummyHead;
        while (n > 0) {
            if (fast == null) return null;
            fast = fast.next;
            n--;
        }
        while (fast != null && fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummyHead.next;
    }

}
