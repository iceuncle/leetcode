package leetcode;

import java.util.HashSet;

/**
 * 快乐数
 */
public class Solution202 {

    public int getNext(int n) {
        int res = 0;
        while (n != 0) {
            res += Math.pow(n % 10, 2);
            n = n / 10;
        }
        return res;
    }


    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            n = getNext(n);
        }
        return n == 1;
    }


}
