package leetcode;

public class Solution143 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public void reorderList(ListNode head) {
        if (head == null)
            return;
        ListNode midNode = getMiddle(head);
        ListNode l1 = head;
        ListNode l2 = midNode.next;
        l2 = reverse(l2);
        midNode.next = null;
        merge(l1, l2);
    }

    private ListNode getMiddle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null, cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }

    private void merge(ListNode l1, ListNode l2) {
        ListNode l1_temp, l2_temp;
        while (l1 != null && l2 != null) {
            l1_temp = l1.next;
            l2_temp = l2.next;

            l1.next = l2;
            l2.next = l1_temp;

            l1 = l1_temp;
            l2 = l2_temp;
        }
    }

}
