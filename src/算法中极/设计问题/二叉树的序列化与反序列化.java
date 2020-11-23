package 算法中极.设计问题;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class 二叉树的序列化与反序列化 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public class Codec {

        public void preOrder(TreeNode root, StringBuilder stringBuilder) {
            if (root == null) {
                stringBuilder.append("None,");
                return;
            }
            stringBuilder.append(root.val).append(",");
            preOrder(root.left, stringBuilder);
            preOrder(root.right, stringBuilder);
        }

        public String serialize(TreeNode root) {
            StringBuilder stringBuilder = new StringBuilder();
            preOrder(root, stringBuilder);
            return stringBuilder.toString();
        }


        public TreeNode deserialize(LinkedList<String> list) {
            if (list.get(0).equals("None")) {
                list.removeFirst();
                return null;
            }
            TreeNode treeNode = new TreeNode(Integer.valueOf(list.get(0)));
            list.removeFirst();
            treeNode.left = deserialize(list);
            treeNode.right = deserialize(list);
            return treeNode;
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[] preOrder = data.split(",");
            LinkedList<String> list = new LinkedList<>(Arrays.asList(preOrder));
            return deserialize(list);
        }

    }

    public static void main(String[] args) {
        二叉树的序列化与反序列化 s = new 二叉树的序列化与反序列化();
        TreeNode treeNode = s.new TreeNode(3);
        treeNode.left = s.new TreeNode(9);
        treeNode.right = s.new TreeNode(20);
        treeNode.right.left = s.new TreeNode(15);
        treeNode.right.right = s.new TreeNode(7);
        System.out.println(s.new Codec().serialize(treeNode));

        TreeNode  root = s.new Codec().deserialize("3,9,None,None,20,15,None,None,7,None,None,");
    }


}
