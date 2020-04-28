package 算法面试题汇总.开始之前;

/**
 * <p>
 * Created by tianyang on 2020/3/12.
 */
public class 只出现一次的数字 {
    public int singleNumber(int[] nums) {
        int ret = 0;
        for (int num : nums) {
            ret = ret ^ num;
        }
        return ret;
    }
}
