package 剑指offer;

/**
 * <p>
 * Created by tianyang on 2020/3/17.
 * 二叉树的深度
 */
public class 面试题55I {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

}
