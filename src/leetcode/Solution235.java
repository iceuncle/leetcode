package leetcode;

/**
 * <p>二叉搜索树的最近公共祖先
 * Created by tianyang on 2018/11/8.
 */
public class Solution235 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        if (left == null) {
            return right;
        } else {
            return left;
        }
    }


    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        // root为空
        if(root == null || p == null || q == null) {
            return null;
        }

        // 如果都小于root，则递归左子树，找到左子树中的p或者q
        if(root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        // 如果都大于root，则递归右子树，找到右子树中的p或者q
        if(root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        // 否则出现分叉，直接返回root
        return root;
    }

}
