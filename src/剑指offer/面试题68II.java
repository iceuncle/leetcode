package 剑指offer;

/**
 * <p>
 * Created by tianyang on 2020/3/17.
 * 二叉树的最近公共祖先
 */
public class 面试题68II {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q)
            return root;
        TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
        TreeNode rightNode = lowestCommonAncestor(root.right, p, q);
        if (leftNode == null)
            return rightNode;
        if (rightNode == null)
            return leftNode;
        return root;
    }

}
