package leetcode;

import java.util.List;

public class Solution86 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode partition(ListNode head, int x) {
        ListNode smallDummyHead = new ListNode(-1);
        ListNode largeDummyHead = new ListNode(-1);
        ListNode smallCurr = smallDummyHead;
        ListNode largeCurr = largeDummyHead;
        ListNode curr = head;
        while (curr != null) {
            if (curr.val < x) {
                smallCurr.next = curr;
                smallCurr = smallCurr.next;
            } else {
                largeCurr.next = curr;
                largeCurr = largeCurr.next;
            }
            curr = curr.next;
        }
        largeCurr.next = null;
        smallCurr.next = largeDummyHead.next;
        return smallDummyHead.next;
    }
}
