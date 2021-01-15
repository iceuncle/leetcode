package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution117 {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;
        public Node(int _val) {
            val = _val;
        }

    }

    public Node connect(Node root) {
        Queue<Node> queue = new LinkedList<>();
        if (root != null) queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (i != size - 1)
                    node.next = queue.peek();
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
        }
        return root;
    }
}
