package 算法中极.树和图;

import java.util.*;

public class 二叉树的中序遍历 {

    public static class TreeNode {
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
        List<Integer> res = new ArrayList();
        inOrder(root, res);
        return res;
    }

    public void inOrder(TreeNode node, List<Integer> res) {
        if (node == null) return;
        inOrder(node.left, res);
        res.add(node.val);
        inOrder(node.right, res);
    }


    public List<Integer> inorderTraversal1(TreeNode root) {
        TreeNode cur = root;
        Deque<TreeNode> stack = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.addLast(cur);
                cur = cur.left;
            } else {
                cur = stack.removeLast();
                res.add(cur.val);
                cur = cur.right;
            }
        }
        return res;
    }

    //2 4 5 6 7 15 23
    public static void main(String[] args) {
        TreeNode root = new TreeNode(15);
        root.left = new TreeNode(6);
        root.right = new TreeNode(23);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(7);
        root.left.left.left = new TreeNode(2);
        root.left.left.right = new TreeNode(5);
        new 二叉树的中序遍历().inorderTraversal1(root);
    }


}
