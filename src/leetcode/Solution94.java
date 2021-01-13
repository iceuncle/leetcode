package leetcode;

import java.util.*;

public class Solution94 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inOrder(root, res);
        return res;
    }

    public void inOrder(TreeNode root, List<Integer> res) {
        if (root == null) return;
        inOrder(root.left, res);
        res.add(root.val);
        inOrder(root.right, res);
    }


    public List<Integer> inorderTraversal2(TreeNode root) {
        TreeNode cur = root;
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.addLast(cur);
                cur = cur.left;
            }
            cur = stack.removeLast();
            res.add(cur.val);
            cur = cur.right;
        }
        return res;
    }
}
