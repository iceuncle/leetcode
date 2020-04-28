package 算法初级.设计问题;

import java.util.Random;

/**
 * <p>
 * Created by tianyang on 2020/3/10.
 * <p>
 * 打乱一个没有重复元素的数组。
 * <p>
 * 示例:
 * <p>
 * // 以数字集合 1, 2 和 3 初始化数组。
 * int[] nums = {1,2,3};
 * Solution solution = new Solution(nums);
 * <p>
 * // 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。
 * solution.shuffle();
 * <p>
 * // 重设数组到它的初始状态[1,2,3]。
 * solution.reset();
 * <p>
 * // 随机返回数组[1,2,3]打乱后的结果。
 * solution.shuffle();
 */
public class ShuffleAnArray {

    class Solution {
        private int[] array;
        private int[] original;

        public Solution(int[] nums) {
            array = nums;
            original = array.clone();
        }

        /**
         * Resets the array to its original configuration and return it.
         */
        public int[] reset() {
            array = original;
            original = original.clone();
            return array;
        }

        /**
         * Returns a random shuffling of the array.
         */
        public int[] shuffle() {
            Random random = new Random();
            for (int i = 0; i < array.length; i++) {
                int randomIndex = i + random.nextInt(array.length - i);
                int temp = array[randomIndex];
                array[randomIndex] = array[i];
                array[i] = temp;
            }
            return array;
        }
    }

}
