package 算法初级.树;

import java.util.Stack;

/**
 * <p>
 * Created by tianyang on 2020/3/9.
 * <p>
 */
public class 验证二叉搜索树 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public boolean isValidBST1(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        double a = -Double.MAX_VALUE;
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            TreeNode temp = stack.pop();
            if (temp.val <= a)
                return false;
            a = temp.val;
            node = temp.right;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(Double.MIN_VALUE);
        System.out.println(0 <= Double.MIN_VALUE);
    }


}
