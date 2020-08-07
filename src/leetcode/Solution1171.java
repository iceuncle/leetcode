package leetcode;

import java.util.HashMap;

/**
 * <p>
 * Created by tianyang on 2020/3/16.
 */
public class Solution1171 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //[1,2,-3,3,1]
    // 0 1 3 0 3 4  3 1
    // [1,2,3,-3,4]
    // 0 1 3 6 3 7  124
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        int sum = 0;
        HashMap<Integer, ListNode> map = new HashMap<>();
        ListNode temp = dummyHead;
        while (temp != null) {
            sum += temp.val;
            map.put(sum, temp);
            temp = temp.next;
        }
        sum = 0;
        temp = dummyHead;
        while (temp != null) {
            sum += temp.val;
            temp.next = map.get(sum).next;
            temp = temp.next;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        Solution1171 solution = new Solution1171();

        //1,2,-3,3,1
        ListNode head = new ListNode(1);
        ListNode head1 = new ListNode(2);
        ListNode head2 = new ListNode(3);
        ListNode head3 = new ListNode(-3);
        ListNode head4 = new ListNode(-2);
        head.next = head1;
        head1.next = head2;
        head2.next = head3;
        head3.next = head4;
        solution.removeZeroSumSublists(head);
    }

}
