package 剑指offer;

/**
 * <p>
 * Created by tianyang on 2020/3/16.
 * 二进制中1的个数
 */
public class 面试题15 {
    public int hammingWeight(int n) {
        int count = 0;
        int temp = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & temp) != 0)
                count++;
            temp <<= 1;
        }
        return count;
    }
}
