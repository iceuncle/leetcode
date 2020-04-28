package 算法面试题汇总.字符串;

import java.util.HashSet;
import java.util.List;

/**
 * <p>
 * Created by tianyang on 2020/3/12.
 * <p>
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 * <p>
 * 说明：
 * <p>
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 示例 1：
 * <p>
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 * 示例 2：
 * <p>
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
 * 注意你可以重复使用字典中的单词。
 * 示例 3：
 * <p>
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 */
public class 单词拆分 {

    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> hashSet = new HashSet<>(wordDict);
        Boolean[] memo = new Boolean[s.length()];
        return backTracking(s, 0, hashSet, memo);
    }

    public boolean backTracking(String s, int start, HashSet<String> wordDict, Boolean[] memo) {
        if (start == s.length())
            return true;
        if (memo[start] != null)
            return memo[start];
        for (int i = start; i < s.length(); i++) {
            String prefix = s.substring(start, i + 1);
            if (wordDict.contains(prefix) && backTracking(s, i + 1, wordDict, memo))
                return memo[start] = true;
        }
        return memo[start] = false;
    }

}
