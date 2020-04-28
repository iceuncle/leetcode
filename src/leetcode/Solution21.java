package leetcode;

/**
 * <p>合并两个有序链表
 * <p>
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * <p>
 * 示例：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * Created by tianyang on 2018/11/5.
 */
public class Solution21 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            ListNode curr = this;
            StringBuilder builder = new StringBuilder();
            while (curr != null) {
                builder.append(curr.val).append("->");
                curr = curr.next;
            }
            return builder.toString();
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode curr = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                curr.next = new ListNode(l1.val);
                l1 = l1.next;
            } else if (l1.val > l2.val) {
                curr.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            curr = curr.next;
        }
        if (l1 != null) {
            curr.next = l1;
        } else {
            curr.next = l2;
        }
        return dummyHead.next;
    }

//    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        ListNode dummyHead = new ListNode(-1);
//        ListNode curr = dummyHead;
//        while (l1 != null & l2 != null) {
//            if (l1.val <= l2.val) {
//                curr.next = new ListNode(l1.val);
//                l1 = l1.next;
//            }else {
//                curr.next = new ListNode(l2.val);
//                l2 = l2.next;
//            }
//            curr = curr.next;
//        }
//        if (l1 != null) {
//            curr.next = l1;
//        }
//        if (l2 != null) {
//            curr.next = l2;
//        }
//        return dummyHead.next;
//    }

    public static void main(String[] args) {
        ListNode node1 = new Solution21.ListNode(1);
        ListNode node2 = new Solution21.ListNode(2);
        ListNode node3 = new Solution21.ListNode(4);

        node1.next = node2;
        node2.next = node3;

        ListNode node4 = new Solution21.ListNode(1);
        ListNode node5 = new Solution21.ListNode(3);
        ListNode node6 = new Solution21.ListNode(4);

        node4.next = node5;
        node5.next = node6;

        System.out.println((new Solution21()).mergeTwoLists(node1, node4).toString());

    }


}
