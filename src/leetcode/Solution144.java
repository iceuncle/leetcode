package leetcode;

import java.util.*;

public class Solution144 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preOrder(root, res);
        return res;
    }

    public void preOrder(TreeNode root, List<Integer> res) {
        if (root == null) return;
        res.add(root.val);
        preOrder(root.left, res);
        preOrder(root.right, res);
    }


    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        if (root != null)
            stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.removeLast();
            res.add(node.val);
            if (node.right != null) stack.addLast(node.right);
            if (node.left != null) stack.addLast(node.left);
        }
        return res;
    }

    public List<Integer> inOrderT(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
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

