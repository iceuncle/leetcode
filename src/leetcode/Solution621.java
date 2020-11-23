package leetcode;

import java.util.Arrays;

/**
 * 任务调度器
 */
public class Solution621 {


    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for (char task : tasks) {
            map[task - 'A']++;
        }
        Arrays.sort(map);
        int time = 0;
        while (map[25] > 0) {
            for (int i = 0; i <= n; i++) {
                if (map[25] == 0) break;
                if (i < 26 && map[25 - i] > 0) {
                    map[25 - i]--;
                }
                time++;
            }
            Arrays.sort(map);
        }
        return time;
    }


    public static void main(String[] args) {
        System.out.println(new Solution621().leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2));
    }
}
