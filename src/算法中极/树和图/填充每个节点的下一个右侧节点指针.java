package 算法中极.树和图;

import java.util.LinkedList;
import java.util.Queue;

public class 填充每个节点的下一个右侧节点指针 {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }


    public Node connect(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (node != null) {
                    if (i != size - 1) node.next = queue.peek();
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
        }
        return root;
    }

    public Node connect1(Node root) {
        if (root == null) return null;
        Node leftMost = root;
        while (leftMost.left != null) {
            Node head = leftMost;
            while (head != null) {
                head.left.next = head.right;
                if (head.next != null)
                    head.right.next = head.next.left;
                head = head.next;
            }
            leftMost = leftMost.left;
        }
        return root;
    }

    public Node connect2(Node root) {
        if (root == null) return null;
        if (root.left != null) {
            root.left.next = root.right;
            root.right.next = root.next == null ? null : root.next.left;
            connect(root.left);
            connect(root.right);
        }
        return root;
    }

}
