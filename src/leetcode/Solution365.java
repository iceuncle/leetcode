package leetcode;

import java.util.*;

/**
 * 有两个容量分别为 x升 和 y升 的水壶以及无限多的水。请判断能否通过使用这两个水壶，从而可以得到恰好 z升 的水？
 * <p>
 * 如果可以，最后请用以上水壶中的一或两个来盛放取得的 z升 水。
 * <p>
 * 你允许：
 * <p>
 * 装满任意一个水壶
 * 清空任意一个水壶
 * 从一个水壶向另外一个水壶倒水，直到装满或者倒空
 */
public class Solution365 {

    public boolean canMeasureWater(int x, int y, int z) {
        if (z > x + y) return false;
        else if (x == z || y == z || x + y == z) return true;
        Queue<List<Integer>> queue = new LinkedList<>();
        Set<List<Integer>> set = new HashSet<>();
        List<Integer> initState = Arrays.asList(0, 0);
        queue.add(initState);
        set.add(initState);
        while (!queue.isEmpty()) {
            List<Integer> cur = queue.poll();
            int remain_x = cur.get(0), remain_y = cur.get(1);
            if (remain_x == z || remain_y == z || remain_x + remain_y == z)
                return true;

            //把x倒满
            List<Integer> tmp1 = Arrays.asList(x, remain_y);
            if (!set.contains(tmp1)) {
                queue.add(tmp1);
                set.add(tmp1);
            }

            //把y倒满
            List<Integer> tmp2 = Arrays.asList(remain_x, y);
            if (!set.contains(tmp2)) {
                queue.add(tmp2);
                set.add(tmp2);
            }

            //把x倒空
            List<Integer> tmp3 = Arrays.asList(0, remain_y);
            if (!set.contains(tmp3)) {
                queue.add(tmp3);
                set.add(tmp3);
            }

            //把y倒空
            List<Integer> tmp4 = Arrays.asList(remain_x, 0);
            if (!set.contains(tmp4)) {
                queue.add(tmp4);
                set.add(tmp4);
            }

            //把x倒向y
            int tmp_x = remain_x + remain_y <= y ? 0 : remain_x + remain_y - y;
            int tmp_y = remain_x + remain_y <= y ? remain_x + remain_y : y;
            List<Integer> tmp5 = Arrays.asList(tmp_x, tmp_y);
            if (!set.contains(tmp5)) {
                queue.add(tmp5);
                set.add(tmp5);
            }

            //把y倒向x
            tmp_x = remain_x + remain_y <= x ? remain_x + remain_y : x;
            tmp_y = remain_x + remain_y <= x ? 0 : remain_x + remain_y - x;
            List<Integer> tmp6 = Arrays.asList(tmp_x, tmp_y);
            if (!set.contains(tmp6)) {
                queue.add(tmp6);
                set.add(tmp6);
            }
        }
        return false;
    }

    public boolean canMeasureWater1(int x, int y, int z) {
        if (z > x + y) return false;
        if (x == z || y == z || x + y == z) return true;
        if (x == 0 || y == 0) return false;
        return z % gcd(x, y) == 0;
    }

    //辗转相除法求最大公约数
    public int gcd(int m, int n) {
        if (m < n) {
            int tmp = n;
            n = m;
            m = tmp;
        }
        if (m % n == 0) return n;
        return gcd(n, m % n);
    }

    public static void main(String[] args) {
        Queue<List<Integer>> queue = new LinkedList<>();
        Set<List<Integer>> set = new HashSet<>();
        queue.add(Arrays.asList(0, 0));
        set.add(Arrays.asList(0, 0));
        List<Integer> cur = queue.poll();
        System.out.println(set.contains(cur));
    }

}
