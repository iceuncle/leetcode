package leetcode;

import java.util.HashMap;

public class Solution106 {


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(inorder, 0, inorder.length, postorder, 0, postorder.length, map);
    }

    public TreeNode buildTree(int[] inorder, int i_start, int i_end,
                              int[] postorder, int p_start, int p_end, HashMap<Integer, Integer> map) {
        if (p_start == p_end) return null;
        int root_val = postorder[p_end - 1];
        int inorderIndex = map.get(root_val);
        int rightNum = i_end - 1 - inorderIndex;
        TreeNode root = new TreeNode(root_val);
        root.right = buildTree(inorder, inorderIndex + 1, i_end, postorder, p_end - 1 - rightNum, p_end - 1, map);
        root.left = buildTree(inorder, i_start, inorderIndex, postorder, p_start, p_end - 1 - rightNum, map);
        return root;
    }

}
