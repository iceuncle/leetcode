package leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 单词的压缩编码
 */
public class Solution820 {

    public int minimumLengthEncoding(String[] words) {
        TreeNode treeNode = new TreeNode();
        HashMap<TreeNode, Integer> hashMap = new HashMap<>();
        for (int index = 0; index < words.length; index++) {
            String word = words[index];
            TreeNode cur = treeNode;
            for (int i = word.length() - 1; i >= 0; i--) {
                cur = cur.getChild(word.charAt(i));
            }
            hashMap.put(cur, index);
        }
        int res = 0;
        for (TreeNode node : hashMap.keySet()) {
            if (node.count == 0)
                res += words[hashMap.get(node)].length() + 1;
        }
        return res;
    }


    class TreeNode {
        TreeNode[] children;
        int count;

        public TreeNode() {
            children = new TreeNode[26];
            count = 0;
        }

        public TreeNode getChild(char c) {
            int index = c - 'a';
            if (children[index] == null) {
                children[index] = new TreeNode();
                count++;
            }
            return children[index];
        }
    }

    public int minimumLengthEncoding1(String[] words) {
        Arrays.sort(words, (o1, o2) -> o2.length() - o1.length());
        Tree tree = new Tree();
        int res = 0;
        for (String word : words) {
            int length = tree.insert(word);
            if (length != 0)
                res += length + 1;
        }
        return res;
    }


    class Tree {
        TreeNode1 root;

        Tree() {
            root = new TreeNode1('0');
        }

        public int insert(String word) {
            TreeNode1 cur = root;
            boolean isNew = false;
            for (int i = word.length() - 1; i >= 0; i--) {
                int index = word.charAt(i) - 'a';
                if (cur.children[index] == null) {
                    isNew = true;
                    cur.children[index] = new TreeNode1(word.charAt(i));
                }
                cur = cur.children[index];
            }
            return isNew ? word.length() : 0;
        }
    }

    class TreeNode1 {
        char val;
        TreeNode1[] children = new TreeNode1[26];

        TreeNode1(char val) {
            this.val = val;
        }
    }
}
