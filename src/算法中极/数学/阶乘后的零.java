package 算法中极.数学;

public class 阶乘后的零 {

    public int trailingZeroes(int n) {
        int res = 0;
        long divisor = 5;
        while (n >= divisor) {
            res += n / divisor;
            divisor *= 5;
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(new 阶乘后的零().trailingZeroes(Integer.MAX_VALUE));
    }
    //536870902

}
