package 算法初级.其他;

/**
 * <p>
 * Created by tianyang on 2020/3/11.
 * <p>
 * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 * <p>
 * 给出两个整数 x 和 y，计算它们之间的汉明距离。
 * <p>
 * 注意：
 * 0 ≤ x, y < 231.
 * <p>
 * 示例:
 * <p>
 * 输入: x = 1, y = 4
 * <p>
 * 输出: 2
 * <p>
 * 解释:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 * ↑   ↑
 *
 *   1 1
 *   0 1
 * <p>
 * 上面的箭头指出了对应二进制位不同的位置。
 */
public class 汉明距离 {

    public int hammingDistance(int x, int y) {
        int z = x ^ y;
        System.out.println(z);
        int k = 1;
        int distance = 0;
        for (int i = 0; i < 32; i++) {
            if ((k & z) != 0)
                distance++;
            k <<= 1;
        }
        return distance;
    }

    public int hammingDistance1(int x, int y) {
        int z = x ^ y;
        return Integer.bitCount(z);
    }

    public static void main(String[] args) {
        System.out.println((new 汉明距离()).hammingDistance(3, 1));
    }
}
