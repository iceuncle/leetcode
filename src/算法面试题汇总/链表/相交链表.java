package 算法面试题汇总.链表;

import java.util.HashSet;

/**
 * <p>
 * Created by tianyang on 2020/3/13.
 */
public class 相交链表 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> set = new HashSet<>();
        ListNode a = headA;
        while (a != null) {
            set.add(a);
            a = a.next;
        }
        ListNode b = headB;
        while (b != null) {
            if (set.contains(b))
                return b;
            b = b.next;
        }
        return null;
    }

}
