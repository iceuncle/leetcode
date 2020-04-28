package 剑指offer;

/**
 * <p>
 * Created by tianyang on 2020/3/16.
 * 反转链表
 *
 * 输入: 1->2->3->4->5->NULL
    输出: 5->4->3->2->1->NULL
 */
public class 面试题24 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

}
