package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution118 {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows <= 0) return res;
        res.add(new ArrayList<Integer>() {{
            add(1);
        }});
        for (int i = 1; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            List<Integer> preList = res.get(i - 1);
            for (int j = 1; j < i; j++) {
                list.add(preList.get(j - 1) + preList.get(j));
            }
            list.add(1);
            res.add(list);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution118().generate(5));
    }

}
