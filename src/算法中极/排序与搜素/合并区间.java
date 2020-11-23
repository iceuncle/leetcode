package 算法中极.排序与搜素;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 合并区间 {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        List<int[]> res = new ArrayList<>();
        int i = 0;
        while (i < intervals.length) {
            int right = intervals[i][1];
            int j = i + 1;
            while (j < intervals.length && intervals[j][0] <= right) {
                right = Math.max(intervals[j][1], right);
                j++;
            }
            res.add(new int[]{intervals[i][0], right});
            i = j;
        }
        return res.toArray(new int[0][]);
    }

}
