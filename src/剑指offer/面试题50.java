package 剑指offer;

import java.util.HashMap;

/**
 * <p>
 * Created by tianyang on 2020/3/17.
 */
public class 面试题50 {
    public char firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (Character c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (Character c : s.toCharArray()) {
            if (map.get(c) == 1)
                return c;
        }
        return ' ';
    }
}
