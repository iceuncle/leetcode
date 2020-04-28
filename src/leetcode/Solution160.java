package leetcode;

/**
 * <p>相交链表
 * Created by tianyang on 2018/11/8.
 */
public class Solution160 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lena = 0, lenb = 0;
        ListNode nodeA = headA;
        ListNode nodeB = headB;

        while (nodeA != null) {
            lena++;
            nodeA = nodeA.next;
        }

        while (nodeB != null) {
            lenb++;
            nodeB = nodeB.next;
        }
        nodeA = headA;
        nodeB = headB;
        if (lena <= lenb) {
            for (int i = 0; i < lenb - lena; i++) {
                nodeB = nodeB.next;
            }
            for (int i = 0; i < lena; i++) {
                if (nodeA.val == nodeB.val) {
                    return nodeA;
                }
                nodeA = nodeA.next;
                nodeB = nodeB.next;
            }
            return null;
        } else {
            for (int i = 0; i < lena - lenb; i++) {
                nodeA = nodeA.next;
            }
            for (int i = 0; i < lenb; i++) {
                if (nodeA.val == nodeB.val) {
                    return nodeA;
                }
                nodeA = nodeA.next;
                nodeB = nodeB.next;
            }
            return null;
        }
    }
}
