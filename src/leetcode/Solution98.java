package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution98 {
    public class TreeNode {
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

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    public boolean isValidBST(TreeNode root, Integer lower, Integer upper) {
        if (root == null) return true;
        if (lower != null && lower >= root.val) return false;
        if (upper != null && upper <= root.val) return false;
        return isValidBST(root.left, lower, root.val) && isValidBST(root.right, root.val, upper);
    }

    public boolean isValidBST2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOder(root, list);
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) >= list.get(i + 1))
                return false;
        }
        return true;
    }

    public void inOder(TreeNode node, List<Integer> res) {
        if (node == null)
            return;
        inOder(node.left, res);
        res.add(node.val);
        inOder(node.right, res);
    }

    public static void main(String[] args) {

    }

}
