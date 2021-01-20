package leetcode;

import java.util.*;

public class Solution120 {


    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] memo = new int[n][n];
        return minimumTotal(triangle, 0, 0, memo);
    }

    public int minimumTotal(List<List<Integer>> triangle, int i, int j, int[][] memo) {
        if (i == triangle.size())
            return 0;
        if (memo[i][j] != 0)
            return memo[i][j];
        memo[i][j] = Math.min(minimumTotal(triangle, i + 1, j, memo),
                minimumTotal(triangle, i + 1, j + 1, memo)) + triangle.get(i).get(j);
        return memo[i][j];
    }

    public int minimumTotal1(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n + 1][n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[0][0];
    }


//    private int minSum = Integer.MAX_VALUE;
//
//    public int minimumTotal(List<List<Integer>> triangle) {
//        dfs(triangle, 0, 0, new ArrayDeque<>(), 0);
//        return minSum;
//    }
//
//    public void dfs(List<List<Integer>> triangle, int index, int curI, Deque<Integer> path, int sum) {
//        if (index == triangle.size()) {
//            minSum = Math.min(sum, minSum);
//            return;
//        }
//        List<Integer> list = triangle.get(index);
//        for (int i = curI; i <= curI + 1 && i < list.size(); i++) {
//            path.addLast(list.get(i));
//            sum += list.get(i);
//            dfs(triangle, index + 1, i, path, sum);
//            path.removeLast();
//            sum -= list.get(i);
//        }
//    }


    public static void main(String[] args) {
        System.out.println(new Solution120().minimumTotal1(new ArrayList<List<Integer>>() {{
            add(new ArrayList<Integer>() {{
                add(2);
            }});
            add(new ArrayList<Integer>() {{
                add(3);
                add(4);
            }});
            add(new ArrayList<Integer>() {{
                add(6);
                add(5);
                add(7);
            }});
            add(new ArrayList<Integer>() {{
                add(4);
                add(1);
                add(8);
                add(3);
            }});
        }}));
    }
}
