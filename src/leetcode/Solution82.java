package leetcode;

import java.util.List;

public class Solution82 {

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

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode prev = dummyHead;
        boolean isUnique = true;
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                isUnique = false;
                cur.next = cur.next.next;
            } else {
                if (isUnique) {
                    prev.next = cur;
                    prev = prev.next;
                }
                cur = cur.next;
                isUnique = true;
            }
        }
        if (cur != null && isUnique) {
            prev.next = cur;
            prev = prev.next;
        }
        prev.next = null;
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode head = (new Solution82()).new ListNode(1);
        head.next = (new Solution82()).new ListNode(2);
        head.next.next = (new Solution82()).new ListNode(3);
        head.next.next.next = (new Solution82()).new ListNode(3);
        head.next.next.next.next = (new Solution82()).new ListNode(4);
        head.next.next.next.next.next = (new Solution82()).new ListNode(4);
        head.next.next.next.next.next.next = (new Solution82()).new ListNode(5);
        new Solution82().deleteDuplicates(head);
    }


}
