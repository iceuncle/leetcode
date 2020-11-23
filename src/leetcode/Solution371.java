package leetcode;

/**
 * 两整数之和
 */
public class Solution371 {

    public int getSum(int a, int b) {
        while (b != 0) {
            int temp = a ^ b;
            b = (a & b) << 1;
            a = temp;
        }
        return a;
    }

}
