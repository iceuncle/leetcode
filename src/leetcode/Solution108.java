package leetcode;

/**
 * 将有序数组转换为二叉搜索树
 */
public class Solution108 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length < 1) {
            return null;
        }
        return solve(nums, 0, nums.length - 1);
    }

    private TreeNode solve(int[] nums, int left, int right) {
        if (left <= right) {
            int mid = left + (right - left) / 2;
            TreeNode root = new TreeNode(nums[mid]);
            root.left = solve(nums, left, mid - 1);
            root.right = solve(nums, mid + 1, right);
            return root;
        }
        return null;
    }
}
