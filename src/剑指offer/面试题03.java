package 剑指offer;

import java.util.HashMap;
import java.util.HashSet;

/**
 * <p>
 * Created by tianyang on 2020/3/16.
 * 数组中重复的数字
 */
public class 面试题03 {

    public int findRepeatNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num))
                return num;
            set.add(num);
        }
        return -1;
    }

}
