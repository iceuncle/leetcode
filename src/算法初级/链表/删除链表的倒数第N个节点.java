package 算法初级.链表;

/**
 * <p>
 * Created by tianyang on 2020/3/4.
 * <p>
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 0- 1->2->3->4->5, 和 n = 2.
 * <p>
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 * <p>
 * 给定的 n 保证是有效的。
 * <p>
 * 进阶：
 * <p>
 * 你能尝试使用一趟扫描实现吗？
 */
public class 删除链表的倒数第N个节点 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode cur = head;
        int len = 0;
        while (cur != null) {
            cur = cur.next;
            len++;
        }
        ListNode pre = dummyHead;
        for (int i = 0; i < len - n; i++) {
            pre = pre.next;
        }
        pre.next = pre.next.next;
        return dummyHead.next;
    }

    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode first = dummyHead;
        ListNode second = dummyHead;
        for (int i = 0; i < n; i++) {
            if (first == null) return null;
            first = first.next;
        }
        while (first != null && first.next != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummyHead.next;
    }

}

