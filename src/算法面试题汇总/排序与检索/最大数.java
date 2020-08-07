package 算法面试题汇总.排序与检索;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * <p>
 * Created by tianyang on 2020/3/16.
 */
public class 最大数 {
    public String largestNumber(int[] nums) {
        String[] strings = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strings[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });
        if (strings[0].equals("0")) return "0";
        StringBuilder ret = new StringBuilder();
        for (String s : strings) {
            ret.append(s);
        }
        System.out.println(ret.toString());
        return ret.toString();
    }

    public String largestNumber1(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) list.add(num);
        list.sort((o1, o2) -> {
            return (o2.toString() + o1.toString()).compareTo(o1.toString() + o2.toString());
        });
        if (list.get(0) == 0) return "0";
        StringBuilder res = new StringBuilder();
        for (Integer integer : list) {
            res.append(integer.toString());
        }
        return res.toString();
    }

    public static void main(String[] args) {
        (new 最大数()).largestNumber(new int[]{3, 30, 34, 5, 9});
    }
}
