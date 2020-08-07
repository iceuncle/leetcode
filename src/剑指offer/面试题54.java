package 剑指offer;

import java.util.PriorityQueue;
import java.util.Stack;

/**
 * <p>
 * Created by tianyang on 2020/3/17.
 * 二叉搜索树的第k大节点
 */
public class 面试题54 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public int kthLargest(TreeNode root, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root != null) stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) heap.add(node.val);
            if (heap.size() > k)
                heap.poll();
            if (node != null) stack.add(node.right);
            if (node != null) stack.add(node.left);
        }
        return heap.peek();
    }

    public int kthLargest1(TreeNode root, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        preOrder(root, heap, k);
        return heap.peek();
    }

    public void preOrder(TreeNode node, PriorityQueue<Integer> heap, int k) {
        if (node == null) return;
        heap.add(node.val);
        if (heap.size() > k)
            heap.poll();
        preOrder(node.left, heap, k);
        preOrder(node.right, heap, k);
    }

}
