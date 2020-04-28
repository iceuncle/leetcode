package 算法初级.链表;

/**
 * <p>
 * Created by tianyang on 2020/3/4.
 * <p>
 * 反转一个单链表。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 * <p>
 * 2-3-4-5-
 */
public class 反转链表 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            ListNode node = this;
            StringBuilder a = new StringBuilder();
            while (node != null) {
                a.append(node.val).append("->");
                node = node.next;
            }
            a.append("NUlL");
            return a.toString();
        }
    }


    public ListNode reverseList(ListNode head) {

        if (head == null || head.next == null)     // 空链或只有一个结点，直接返回头指针
        {
            return head;
        } else                                        // 有两个以上结点
        {
            ListNode newHead = reverseList(head.next); // 反转以第二个结点为头的子链表

            // head->next 此时指向子链表的最后一个结点

            // 将之前的头结点放入子链尾
            head.next.next = head;
            head.next = null;

            return newHead;
        }
    }

    public ListNode reverseList1(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode t = cur.next;
            cur.next = pre;
            pre = cur;
            cur = t;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println(head);
        head = (new 反转链表()).reverseList(head);
        System.out.println(head);
    }


}
