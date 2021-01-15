package leetcode;

import java.util.*;

public class Solution113 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new LinkedList<>();
        dfs(root, sum, path, res);
        return res;
    }

    public void dfs(TreeNode root, int sum, Deque<Integer> path, List<List<Integer>> res) {
        if (root == null) return;
        path.addLast(root.val);
        if (root.left == null && root.right == null && sum == root.val) {
            res.add(new ArrayList<>(path));
        }
        dfs(root.left, sum - root.val, path, res);
        dfs(root.right, sum - root.val, path, res);
        path.removeLast();
    }


    public List<List<Integer>> pathSum2(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> queueVal = new LinkedList<>();
        HashMap<TreeNode, TreeNode> map = new HashMap<>();
        queue.add(root);
        queueVal.add(root.val);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int temp = queueVal.poll();
            if (node.left == null && node.right == null && temp == sum) {
                res.add(getPath(node, map));
            }
            if (node.left != null) {
                queue.add(node.left);
                queueVal.add(temp + node.left.val);
                map.put(node.left, node);
            }
            if (node.right != null) {
                queue.add(node.right);
                queueVal.add(temp + node.right.val);
                map.put(node.right, node);
            }
        }
        return res;
    }

    private List<Integer> getPath(TreeNode node, HashMap<TreeNode, TreeNode> map) {
        LinkedList<Integer> list = new LinkedList<>();
        while (node != null) {
            list.addFirst(node.val);
            node = map.get(node);
        }
        return list;
    }


    public static void main(String[] args) {
        TreeNode head = new TreeNode(5);
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(8);
        TreeNode node3 = new TreeNode(11);
        TreeNode node5 = new TreeNode(13);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(2);
        TreeNode node11 = new TreeNode(5);
        TreeNode node12 = new TreeNode(1);

        head.left = node1;
        head.right = node2;

        node1.left = node3;
        node1.right = null;
        node2.left = node5;
        node2.right = node6;

        node3.left = node7;
        node3.right = node8;

        node6.left = node11;
        node6.right = node12;

        System.out.println(new Solution113().pathSum(head, 22));
    }

}
