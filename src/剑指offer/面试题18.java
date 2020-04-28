package 剑指offer;

/**
 * <p>
 * Created by tianyang on 2020/3/16.
 * 删除链表的节点
 */
public class 面试题18 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteNode(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode node = dummyHead;
        while (node != null && node.next != null) {
            if (node.next.val == val)
                node.next = node.next.next;
            node = node.next;
        }
        return dummyHead.next;
    }


}
