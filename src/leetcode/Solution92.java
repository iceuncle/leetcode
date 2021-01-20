package leetcode;

import java.util.List;

public class Solution92 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode prev = null, cur = head;
        int index = 1;
        while (index < m) {
            prev = cur;
            cur = cur.next;
            index++;
        }
        ListNode coo = prev, tail = cur;
        while (index <= n) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
            index++;
        }
        if (coo != null)
            coo.next = prev;
        else
            head = prev;
        tail.next = cur;
        return head;
    }

    public ListNode reverseBetween1(ListNode head, int m, int n) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode prev = dummyHead;
        int index = 1;
        while (index < m) {
            prev = prev.next;
            index++;
        }
        ListNode coo = prev, tail = prev.next;
        ListNode cur = prev.next;
        prev = null;
        while (index <= n) {
            index++;
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        coo.next = prev;
        tail.next = cur;
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new Solution92().new ListNode(3);
//        head.next = new Solution92().new ListNode(5);
        new Solution92().reverseBetween1(head, 1, 1);
    }

}
