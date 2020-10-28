package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//分割回文串
public class Solution131 {

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        Stack<String> path = new Stack<>();
        int len = s.length();
        if (len == 0) return res;
        backTracking(s, 0, len, path, res);
        return res;
    }

    public void backTracking(String s, int start, int len, Stack<String> path, List<List<String>> res) {
        if (start == len) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < len; i++) {
            System.out.println("start:" + start + " i:" + i + " isHuiWen:" + isHuiWen(s, start, i));
            if (!isHuiWen(s, start, i)) {
                continue;
            }
            path.add(s.substring(start, i + 1));
            backTracking(s, i + 1, len, path, res);
            path.pop();
        }
    }


    public boolean isHuiWen(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution131().partition("aab"));
    }

}
