package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：n = 3
 * 输出：[
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 */
public class Solution22 {


    //T O(4^n / √n)
    //S O(n)
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        dfs("", n, n, result);
        return result;
    }

    public void dfs(String s, int left, int right, List<String> result) {
        System.out.println("left:" + left + " right:" + right);
        if (left == 0 && right == 0) {
            result.add(s);
            return;
        }

        if (left > 0)
            dfs(s + "(", left - 1, right, result);
        if (right > 0 && right > left)
            dfs(s + ")", left, right - 1, result);

    }


    public static void main(String[] args) {
        System.out.println(new Solution22().generateParenthesis(2));
    }
}
