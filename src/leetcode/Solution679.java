package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution679 {

    public boolean judgePoint24(int[] nums) {
        List<Double> list = new ArrayList<>();
        for (int num : nums) {
            list.add((double) num);
        }
        return helper(list);
    }

    public boolean helper(List<Double> list) {
        if (list.size() == 0)
            return false;
        if (list.size() == 1) {
            return Math.abs(list.get(0) - 24) <= 1e-6;
        }
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (i == j) continue;
                List<Double> list2 = new ArrayList<>();
                for (int k = 0; k < list.size(); k++) {
                    if (k != i && k != j)
                        list2.add(list.get(k));
                }
                for (int k = 0; k <= 3; k++) {
                    if (k <= 1 && j > i) continue;
                    if (k == 0)
                        list2.add(list.get(i) + list.get(j));
                    else if (k == 1)
                        list2.add(list.get(i) * list.get(j));
                    else if (k == 2)
                        list2.add(list.get(i) - list.get(j));
                    else {
                        if (list.get(j) == 0) return false;
                        else list2.add(list.get(i) / list.get(j));
                    }
                    if (helper(list2)) return true;
                    list2.remove(list2.size() - 1);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution679().judgePoint24(new int[]{4, 1, 8, 7}));
    }

}
