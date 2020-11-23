package 算法中极.数学;

public class x的平方根 {

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


    public static void main(String[] args) {
//        System.out.println(new x的平方根().mySqrt(10000));
        System.out.println(new x的平方根().mySqrt(Integer.MAX_VALUE));
    }

}
