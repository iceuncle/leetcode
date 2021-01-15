package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution112 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null)
            return root.val == sum;
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    public boolean hasPathSum2(TreeNode root, int sum) {
        if (root == null) return false;
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> queueVal = new LinkedList<>();
        queue.add(root);
        queueVal.add(root.val);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int temp = queueVal.poll();
            if (node.left == null && node.right == null) {
                if (temp == sum) return true;
            }
            if (node.left != null) {
                queue.add(node.left);
                queueVal.add(temp + node.left.val);
            }
            if (node.right != null) {
                queue.add(node.right);
                queueVal.add(temp + node.right.val);
            }
        }
        return false;
    }

}
