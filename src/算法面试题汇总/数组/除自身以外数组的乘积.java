package 算法面试题汇总.数组;

/**
 * <p>
 * Created by tianyang on 2020/3/12.
 */
public class 除自身以外数组的乘积 {

    public int[] productExceptSelf(int[] nums) {
        int[] leftArray = new int[nums.length];
        int[] rightArray = new int[nums.length];
        leftArray[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            leftArray[i] = leftArray[i - 1] * nums[i - 1];
        }
        rightArray[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            rightArray[i] = rightArray[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < nums.length; i++)
            leftArray[i] *= rightArray[i];
        return leftArray;
    }

}
