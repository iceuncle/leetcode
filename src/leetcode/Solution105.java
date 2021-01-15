package leetcode;

import java.util.HashMap;

public class Solution105 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
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

    public static void main(String[] args) {
        new Solution105().buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
    }
}
