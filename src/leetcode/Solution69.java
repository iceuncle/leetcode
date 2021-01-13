package leetcode;

/**
 * x的平方根
 */
public class Solution69 {

    public int mySqrt(int x) {
        int left = 0, right = x, res = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if ((long) mid * mid <= x) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }

    public int mySqrt1(int x) {
        int left = 0, right = x;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if ((long) mid * mid <= x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        new Solution69().mySqrt(9);
        new Solution69().mySqrt(88);
        new Solution69().mySqrt(Integer.MAX_VALUE);
        new Solution69().mySqrt(2147395599);
    }

}
