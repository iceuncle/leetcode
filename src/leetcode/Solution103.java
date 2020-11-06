package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution103 {

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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> res = new ArrayList<>();
        //奇数层从左往右，偶数层从右往左
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            LinkedList<Integer> deque = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node != null) {
                    queue.add(node.left);
                    queue.add(node.right);
                    if (level % 2 == 1)
                        deque.addLast(node.val);
                    else {
                        deque.addFirst(node.val);
                    }
                }
            }
            if (!deque.isEmpty())
                res.add(deque);
        }
        return res;
    }

}
