package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * 组合 回溯
 */
public class Solution77 {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (k <= 0 || n < k)
            return res;
        backTracking(n, k, 0, new ArrayDeque<>(), res);
        return res;
    }

    public void backTracking(int n, int k, int index, ArrayDeque<Integer> path, List<List<Integer>> res) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < n; i++) {
            path.addLast(i + 1);
            backTracking(n, k, i + 1, path, res);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution77().combine(4, 2));
    }


}
