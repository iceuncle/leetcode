package leetcode;

import java.util.Random;

public class Solution470 {

    public int rand10() {
        int res;
        do {
            int a = rand7();
            int b = rand7();
            res = (a - 1) * 7 + b;
        } while (res > 40);
        return (res - 1) % 10 + 1;
    }

    public int rand7() {
        return new Random().nextInt(7) + 1;
    }

}
