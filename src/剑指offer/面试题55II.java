package 剑指offer;

/**
 * <p>
 * Created by tianyang on 2020/3/17.
 * 平衡二叉树
 */
public class 面试题55II {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private boolean isBalanced = true;

    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        getDepth(root);
        return isBalanced;
    }


    public int getDepth(TreeNode root) {
        if (root == null)
            return 0;
        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);
        if (Math.abs(leftDepth - rightDepth) > 1)
            isBalanced = false;
        return Math.max(leftDepth, rightDepth) + 1;
    }

}
