package 算法初级.链表;

import java.util.Stack;

/**
 * <p>
 * Created by tianyang on 2020/3/5.
 * 请判断一个链表是否为回文链表。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 * <p>
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 */
public class 回文链表 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public boolean isPalindrome(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp.val);
            temp = temp.next;
        }
        temp = head;
        while (stack.size() != 0) {
            if (stack.pop() != temp.val) {
                return false;
            }
            temp = temp.next;
        }
        return true;
    }

    public boolean isPalindrome1(ListNode head) {
        int len = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            len++;
        }
        int mid = 0;
        if (len % 2 != 0) mid = len / 2 + 1;
        else mid = len / 2;
        ListNode cur = head;
        ListNode pre = null;
        for (int i = 0; i < mid; i++)
            cur = cur.next;
        while (cur != null) {
            ListNode t = cur.next;
            cur.next = pre;
            pre = cur;
            cur = t;
        }
        temp = head;
        while (pre != null) {
            if (temp.val != pre.val)
                return false;
            temp = temp.next;
            pre = pre.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
//        head.next.next = new ListNode(2);
//        head.next.next.next = new ListNode(1);
        System.out.println(head);
        boolean bol = (new 回文链表()).isPalindrome1(head);
        System.out.println(bol);
    }
}
