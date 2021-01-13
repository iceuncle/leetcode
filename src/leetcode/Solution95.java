package leetcode;

import java.util.LinkedList;
import java.util.List;

public class Solution95 {
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


    public List<TreeNode> generateTrees(int n) {
        if (n == 0)
            return new LinkedList<>();
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> res = new LinkedList<>();
        if (start > end) {
            res.add(null);
            return res;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftTrees = generateTrees(start, i - 1);
            List<TreeNode> rightTrees = generateTrees(i + 1, end);
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode cur = new TreeNode(i);
                    cur.left = left;
                    cur.right = right;
                    res.add(cur);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution95().generateTrees(3));
    }


}
