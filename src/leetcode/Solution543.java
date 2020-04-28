package leetcode;

/**
 * <p>
 * Created by tianyang on 2020/3/10.
 * 二叉树的直径
 */
public class Solution543 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int res = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return res;
    }

    public int dfs(TreeNode node) {
        if (node == null)
            return 0;
        int leftDepth = dfs(node.left);
        int rightDepth = dfs(node.right);
        res = Math.max(res, leftDepth + rightDepth);
        return Math.max(leftDepth, rightDepth) + 1;
    }

}
