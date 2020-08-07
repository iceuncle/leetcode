package 每日一题;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * Created by tianyang on 2020/3/6.
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * <p>
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 * <p>
 * 示例 1：
 * <p>
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 * 示例 2：
 * <p>
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 * <p>
 * 限制：
 * <p>
 * 1 <= target <= 10^5
 */
public class 和为s的连续正数序列 {

    //        (a + a + n - 1) * n = target * 2;
    public int[][] findContinuousSequence(int target) {
        List<int[]> result = new ArrayList<>();
        double EPS = 1e-6;
        for (int n = target / 2; n >= 2; n--) {
            double a = ((double) target * 2 / n + 1 - n) / 2;
            if (a > 0 && (a - (int) a) < EPS) {
                int[] ret = new int[n];
                for (int i = 0; i < n; i++) {
                    ret[i] = (int) a++;
                }
                result.add(ret);
            }
        }
        return result.toArray(new int[0][]);
    }

    public int[][] findContinuousSequence1(int target) {
        List<int[]> result = new ArrayList<>();
        for (int i = 1; i <= target / 2; i++) {
            int sum = 0;
            int a = i;
            while (sum < target) {
                sum += a++;
            }
            if (sum == target) {
                int[] ret = new int[a - i];
                for (int j = 0; j < ret.length; j++) {
                    ret[j] = i + j;
                }
                result.add(ret);
            }
        }


        return result.toArray(new int[0][]);
    }
}
