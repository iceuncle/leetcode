package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * Created by tianyang on 2020/3/16.
 */
public class Solution187 {
    public List<String> findRepeatedDnaSequences(String s) {

        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i + 10 <= s.length(); i++) {
            String str = s.substring(i, i + 10);
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        List<String> res = new ArrayList<>();
        for (String key : map.keySet()) {
            if (map.get(key) > 1)
                res.add(key);
        }
        return res;
    }
}
