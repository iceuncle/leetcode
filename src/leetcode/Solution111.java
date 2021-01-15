package leetcode;

import sun.applet.Main;

public class Solution111 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }


    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int m1 = minDepth(root.left);
        int m2 = minDepth(root.right);
        if (root.left == null || root.right == null)
            return m1 + m2 + 1;
        return Math.min(m1, m2) + 1;
    }


}
