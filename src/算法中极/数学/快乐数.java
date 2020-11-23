package 算法中极.数学;

import java.util.HashSet;

public class 快乐数 {

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

    public static void main(String[] args) {
        System.out.println(new 快乐数().isHappy(19));
    }

}
