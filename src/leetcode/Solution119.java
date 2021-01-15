package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>(rowIndex + 1);
        for (int i = 0; i < rowIndex; i++) {
            for (int j = i - 1; j >= 1; j--) {
                res.set(j, res.get(j - 1) + res.get(j));
            }
            res.set(i, 1);
        }
        return res;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>() {{
            add(1);
            add(2);
            add(3);
        }};
        System.out.println(Arrays.toString(list.toArray()));
    }
}
