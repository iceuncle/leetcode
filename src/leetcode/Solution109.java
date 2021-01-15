package leetcode;

import java.util.List;

public class Solution109 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode sortedListToBST(ListNode head) {
        return buildTree(head, null);
    }

    public TreeNode buildTree(ListNode left, ListNode right) {
        if (left == right) return null;
        ListNode mid = getMedium(left, right);
        TreeNode root = new TreeNode(mid.val);
        root.left = buildTree(left, mid);
        root.right = buildTree(mid.next, right);
        return root;
    }


    public ListNode getMedium(ListNode left, ListNode right) {
        ListNode slow = left, fast = left;
        while (fast!=right && fast.next!=right) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
