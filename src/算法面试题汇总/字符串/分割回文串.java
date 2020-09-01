package 算法面试题汇总.字符串;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * <p>
 * Created by tianyang on 2020/3/12.
 * <p>
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 * <p>
 * 返回 s 所有可能的分割方案。
 * <p>
 * 示例:
 * <p>
 * 输入: "aab"
 * 输出:
 * [
 * ["aa","b"],
 * ["a","a","b"]
 * ]
 */

public class 分割回文串 {

    public List<List<String>> partition(String s) {
        int len = s.length();
        List<List<String>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }
        Stack<String> stack = new Stack<>();
        backtracking(s, 0, len, stack, res);
        return res;
    }

    private void backtracking(String s, int start, int len, Stack<String> path, List<List<String>> res) {
        if (start == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < len; i++) {
            System.out.printf("  start i" + start + i);
            if (!checkPalindrome(s, start, i)) {
                continue;
            }
            path.add(s.substring(start, i + 1));
            backtracking(s, i + 1, len, path, res);
            path.pop();
        }
    }

    private boolean checkPalindrome(String str, int left, int right) {
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }


    public static void main(String[] args) {
        (new 分割回文串()).partition("aab");
    }

}
