package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * 常数时间插入删除和获取随机元素
 */
public class Solution380 {

    class RandomizedSet {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        /**
         * Initialize your data structure here.
         */
        public RandomizedSet() {
            map = new HashMap<>();
            list = new ArrayList<>();
        }

        /**
         * Inserts a value to the set. Returns true if the set did not already contain the specified element.
         */
        public boolean insert(int val) {
            if (map.containsKey(val))
                return false;
            map.put(val, list.size());
            list.add(val);
            return true;
        }

        /**
         * Removes a value from the set. Returns true if the set contained the specified element.
         */
        public boolean remove(int val) {
            if (!map.containsKey(val))
                return false;
            int index = map.get(val);
            int lastIndex = list.size() - 1;
            list.set(index, list.get(lastIndex));
            map.put(list.get(lastIndex), index);
            list.remove(lastIndex);
            map.remove(val);
            return true;
        }

        /**
         * Get a random element from the set.
         */
        public int getRandom() {
            return list.get(new Random().nextInt(list.size()));
        }
    }

}
