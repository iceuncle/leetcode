package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给出一个区间的集合，请合并所有重叠的区间。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 * <p>
 * 输入: intervals = [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * 注意：输入类型已于2019年4月15日更改。 请重置默认代码定义以获取新方法签名。
 * <p>
 * [1, 3] [2, 6] [3, 7] [8,10]
 * <p>
 * [[1, 3], [2, 6], [8, 10], [15, 18]]
 */
public class Solution56 {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0)
            return null;
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        List<int[]> resList = new ArrayList<>();
        int i = 0;
        while (i < intervals.length) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            while (i < intervals.length - 1 && intervals[i + 1][0] <= right) {
                right = Math.max(right, intervals[i + 1][1]);
                i++;
            }
            resList.add(new int[]{left, right});
            i++;
        }
        return resList.toArray(new int[0][]);
    }

    //双指针
    public int[][] merge1(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        List<int[]> resList = new ArrayList<>();
        int i = 0;
        while (i < intervals.length) {
            int right = intervals[i][1];
            int j = i + 1;
            while (j < intervals.length && intervals[j][0] <= right) {
                right = Math.max(right, intervals[j][1]);
                j++;
            }
            resList.add(new int[]{intervals[i][0], right});
            i = j;
        }
        return resList.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new Solution56().merge(new int[][]{{1, 3}, {8, 10}, {2, 6}, {15, 18}})));
    }
}
