package 剑指offer;

/**
 * <p>
 * Created by tianyang on 2020/3/16.
 * 打印从1到最大的n位数
 */
public class 面试题17 {

    public int[] printNumbers(int n) {
        int len = (int) Math.pow(10, n) - 1;
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = i + 1;
        }
        return res;
    }

}
