package 算法中极.树和图;

import java.util.*;

public class 二叉搜索树中第K小的元素 {

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

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        return list.get(k - 1);
    }

    public void inOrder(TreeNode node, List<Integer> list) {
        if (node == null) return;
        inOrder(node.left, list);
        list.add(node.val);
        inOrder(node.right, list);
    }


    public int kthSmallest1(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.add(cur);
                cur = cur.left;
            } else {
                cur = stack.removeLast();
                k--;
                if (k == 0) return cur.val;
                cur = cur.right;
            }
        }
        throw new IllegalArgumentException("error");
    }


    public int kthSmallest2(TreeNode root, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            if (pop != null) {
                heap.add(pop.val);
                if (heap.size() > k)
                    heap.poll();
                stack.add(pop.left);
                stack.add(pop.right);
            }
        }
        return heap.isEmpty() ? 0 : heap.peek();
    }

}
