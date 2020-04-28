package 算法初级.其他;

/**
 * <p>
 * Created by tianyang on 2020/3/11.
 * <p>
 * 颠倒给定的 32 位无符号整数的二进制位。
 * <p>
 * 1101
 * 0 1  110
 *
 */
public class 颠倒二进制位 {

    public int reverseBits(int n) {
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            ret <<= 1;
            ret |= n & 1;
            n >>= 1;
        }
        return ret;
    }

    public int reverseBits1(int n) {
        int res = 0;
        int count = 0;
        while (count < 32) {
            res <<= 1;  //res 左移一位空出位置
            res |= (n & 1); //得到的最低位加过来
            System.out.println("res  " + Integer.toBinaryString(res));
            n >>= 1;//原数字右移一位去掉已经处理过的最低位
            System.out.println("n  " + Integer.toBinaryString(n));
            count++;
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(43261596));
        System.out.println((new 颠倒二进制位()).reverseBits(43261596));
    }

}
