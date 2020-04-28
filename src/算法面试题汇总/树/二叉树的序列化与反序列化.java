package 算法面试题汇总.树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <p>
 * Created by tianyang on 2020/3/16.
 */
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

        public String serialize(TreeNode root) {
            StringBuilder builder = new StringBuilder();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                TreeNode node = queue.remove();
                builder.append(node.val).append(",");
                queue.add(node.left);
                queue.add(node.right);
            }
            return builder.substring(0, builder.length() - 1);
        }

    }
}
