package leetcode;

import java.util.*;

/**
 * O(1) 时间插入、删除和获取随机元素 - 允许重复
 */
public class Solution381 {


    class RandomizedCollection {

        HashMap<Integer, Set<Integer>> map;
        List<Integer> list;

        /**
         * Initialize your data structure here.
         */
        public RandomizedCollection() {
            map = new HashMap<>();
            list = new ArrayList<>();
        }

        /**
         * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
         */
        public boolean insert(int val) {
//            Set<Integer> set = map.get(val);
//            if (set == null) set = new HashSet<>();
            Set<Integer> set = map.getOrDefault(val, new HashSet<>());
            set.add(list.size());
            list.add(val);
            map.put(val, set);
            return set.size() == 1;
        }

        /**
         * Removes a value from the collection. Returns true if the collection contained the specified element.
         */
        public boolean remove(int val) {
            if (!map.containsKey(val))
                return false;

            int index = map.get(val).iterator().next();
            int lastIndex = list.size() - 1;
            int lastVal = list.get(lastIndex);

            list.set(index, lastVal);
            map.get(val).remove(index);
            map.get(lastVal).remove(lastIndex);
            if (index != lastIndex)
                map.get(lastVal).add(index);
            if (map.get(val).size() == 0) {
                map.remove(val);
            }
            list.remove(lastIndex);
            return true;
        }

        /**
         * Get a random element from the collection.
         */
        public int getRandom() {
            return list.get(new Random().nextInt(list.size()));
        }
    }

}
