package 算法中极.树和图;

import java.util.HashMap;

public class 从前序与中序遍历序列构造二叉树 {

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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preorder.length, inorder, 0, inorder.length, map);
    }

    public TreeNode buildTree(int[] preorder, int p_start, int p_end, int[] inorder,
                              int i_start, int i_end, HashMap<Integer, Integer> map) {

        if (p_start == p_end) return null;
        int root_val = preorder[p_start];
        int root_inorder_index = map.get(root_val);
        int leftNum = root_inorder_index - i_start;
        TreeNode root = new TreeNode(root_val);
        root.left = buildTree(preorder, p_start + 1, p_start + 1 + leftNum,
                inorder, i_start, root_inorder_index, map);
        root.right = buildTree(preorder, p_start + 1 + leftNum, p_end,
                inorder, root_inorder_index + 1, i_end, map);
        return root;
    }

}
