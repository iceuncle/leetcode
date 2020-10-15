package leetcode;

import java.util.*;

public class Solution199 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //BFS 广度优先
    public List<Integer> rightSideView1(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node != null) {
                    if (i == size - 1)
                        result.add(node.val);
                    if (node.left != null)
                        queue.add(node.left);
                    if (node.right != null)
                        queue.add(node.right);
                }
            }
        }
        return result;
    }

    //DFS
    public List<Integer> result = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        bfs(root, 0);
        return result;
    }

    public void bfs(TreeNode root, int depth) {
        if (root == null)
            return;
        if (depth == result.size())
            result.add(root.val);
        bfs(root.right, depth + 1);
        bfs(root.left, depth + 1);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        List<Integer> list = new Solution199().rightSideView(treeNode);
        System.out.println(list);
    }

}
