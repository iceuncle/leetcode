package 算法中极.其它;

public class 两整数之和 {

    //010+110 = 110
    public int getSum(int a, int b) {
        while (b != 0) {
            int temp = a ^ b;
            b = (a & b) << 1;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(new 两整数之和().getSum(4, 10));
    }

}
