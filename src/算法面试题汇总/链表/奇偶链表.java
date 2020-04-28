package 算法面试题汇总.链表;

import java.util.HashMap;

/**
 * <p>
 * Created by tianyang on 2020/3/16.
 */
public class 奇偶链表 {

    public int titleToNumber(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            map.put((char) ('A' + i), i + 1);
        }
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += map.get(s.charAt(s.length() - 1 - i)) * Math.pow(26, i);
        }
        return sum;
    }

    // AB 26*0+1 =1
    public int titleToNumber1(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum = 26 * sum + s.charAt(i) - 'A' + 1;
        }
        return sum;
    }
}
