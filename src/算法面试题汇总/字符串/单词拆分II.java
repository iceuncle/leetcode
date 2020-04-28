package 算法面试题汇总.字符串;

import java.util.*;

/**
 * <p>
 * Created by tianyang on 2020/3/12.
 * <p>
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的句子。
 * <p>
 * 说明：
 * <p>
 * 分隔时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 示例 1：
 * <p>
 * 输入:
 * s = "catsanddog"
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * 输出:
 * [
 * "cats and dog",
 * "cat sand dog"
 * ]
 */
public class 单词拆分II {
    List<String> res = new ArrayList<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> hashSet = new HashSet<>(wordDict);

        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                dp[i][j] = wordDict.contains(s.substring(i, j + 1));
            }
        }
        backTracking(s, 0, hashSet, new ArrayDeque<String>(), dp);

        return res;
    }

    public void backTracking(String s, int start, HashSet<String> wordDict, ArrayDeque<String> path, boolean[][] dp) {
        if (start == s.length()) {
            StringBuilder stringBuilder = new StringBuilder();
            ArrayDeque<String> deque = path.clone();
            while (!deque.isEmpty())
                stringBuilder.append(deque.pollFirst() + " ");
            res.add(stringBuilder.substring(0, stringBuilder.length() - 1));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            String prefix = s.substring(start, i + 1);
            if (!dp[start][i])
                continue;
            path.addLast(prefix);
            backTracking(s, i + 1, wordDict, path, dp);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        String[] strings = new String[]{"cat", "cats", "and", "sand", "dog"};
        (new 单词拆分II()).wordBreak("catsanddog", Arrays.asList(strings));
    }
}
