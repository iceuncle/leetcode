package 算法面试题汇总.树;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * <p>
 * Created by tianyang on 2020/3/16.
 */
public class 二叉搜索树中第K小的元素 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int kthSmallest(TreeNode root, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        preOrder(root, heap, k);
        return heap.poll();
    }

    public void preOrder(TreeNode root, PriorityQueue<Integer> heap, int k) {
        if (root == null)
            return;
        heap.add(root.val);
        if (heap.size() > k) {
            heap.poll();
        }
        preOrder(root.left, heap, k);
        preOrder(root.right, heap, k);
    }

    public int kthSmallest2(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        return list.get(k - 1);
    }

    public void inOrder(TreeNode root, List<Integer> list) {
        if (root != null) {
            inOrder(root.left, list);
            list.add(root.val);
            inOrder(root.right, list);
        }
    }
}
