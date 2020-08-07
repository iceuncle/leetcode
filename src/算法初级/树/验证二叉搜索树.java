package 算法初级.树;

import java.util.ArrayList;
import java.util.List;
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

    public boolean isValidBST(TreeNode root) {

        return helper(root, null, null);
    }

    public boolean helper(TreeNode root, Integer lower, Integer upper) {
        if (root == null) return true;
        int val = root.val;
        if (lower != null && lower >= val) return false;
        if (upper != null && upper <= val) return false;
        return helper(root.left, lower, val) && helper(root.right, val, upper);
    }


    List<Integer> res = new ArrayList<>();

    public boolean isValidBST2(TreeNode root) {
        inOrder(root);

        for (int i = 0; i < res.size() - 1; i++) {
            if (res.get(i) >= res.get(i + 1))
                return false;
        }
        return true;
    }

    public void inOrder(TreeNode node) {
        if (node != null) {
            inOrder(node.left);
            res.add(node.val);
            inOrder(node.right);
        }
    }

    public static void main(String[] args) {
        System.out.println(Double.MIN_VALUE);
        System.out.println(0 <= Double.MIN_VALUE);
    }


}
