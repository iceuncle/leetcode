package 算法中极.回溯算法;

import java.util.ArrayList;
import java.util.List;

public class 括号生成 {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        dfs("", n, n, result);
        return result;

    }

    public void dfs(String s, int left, int right, List<String> result) {
        if (left == 0 && right == 0) {
            result.add(s);
            return;
        }
        if (left > right)
            return;
        if (left > 0)
            dfs(s + "(", left - 1, right, result);
        if (right > 0)
            dfs(s + ")", left, right - 1, result);
    }

    public static void main(String[] args) {
        System.out.println(new 括号生成().generateParenthesis(3));
    }
}
