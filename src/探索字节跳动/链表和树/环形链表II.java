package 探索字节跳动.链表和树;

import java.util.HashSet;

/**
 * <p>
 * Created by tianyang on 2020/3/27.
 */
public class 环形链表II {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (true) {
            if (fast == null || fast.next == null)
                return null;
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                break;
        }
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public ListNode detectCycle1(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        ListNode node = head;
        while (node != null) {
            if (set.contains(node)) return node;
            set.add(node);
            node = node.next;
        }
        return null;
    }

}
