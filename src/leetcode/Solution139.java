package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Solution139 {

    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> hashSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && hashSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public boolean wordBreak1(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        Boolean[] memo = new Boolean[s.length()];
        return helper(s, 0, set, memo);
    }

    public boolean helper(String s, int begin, HashSet<String> wordDict, Boolean[] memo) {
        if (begin == s.length())
            return true;
        if (memo[begin] != null)
            return memo[begin];
        for (int i = begin; i < s.length(); i++) {
            String prefix = s.substring(begin, i + 1);
            if (wordDict.contains(prefix) && helper(s, i + 1, wordDict, memo))
                return memo[begin] = true;
        }
        return memo[begin] = false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution139().wordBreak1("leetcode", new ArrayList<String>() {{
            add("leet");
            add("code");
        }}));
    }
}
