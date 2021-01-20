package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution129 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

    }

    private int sum = 0;

    public int sumNumbers(TreeNode root) {
        dfs(root, new StringBuilder());
        return sum;
    }

    public void dfs(TreeNode root, StringBuilder builder) {
        if (root == null) return;
        builder.append(root.val);
        if (root.left == null && root.right == null) {
            sum += Integer.parseInt(builder.toString());
        }
        dfs(root.left, builder);
        dfs(root.right, builder);
        builder.deleteCharAt(builder.length() - 1);
    }

    public static void main(String[] args) {
        TreeNode root = new Solution129().new TreeNode(1);
        root.left = new Solution129().new TreeNode(2);
        root.right = new Solution129().new TreeNode(3);
        System.out.println(new Solution129().sumNumbers(root));
    }
}
