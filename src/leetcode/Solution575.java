package leetcode;

import java.util.Arrays;
import java.util.HashSet;

public class Solution575 {

    public int distributeCandies(int[] candies) {
        Arrays.sort(candies);
        int count = 1;
        for (int i = 1; i < candies.length && count < candies.length / 2; i++) {
            if (candies[i] > candies[i - 1])
                count++;
        }
        return count;
    }

    public int distributeCandies1(int[] candies) {
        HashSet<Integer> set = new HashSet<>();
        for (int candy : candies) {
            set.add(candy);
        }
        return Math.min(set.size(), candies.length / 2);
    }

}
