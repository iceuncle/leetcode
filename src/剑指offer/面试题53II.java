package 剑指offer;

/**
 * <p>
 * Created by tianyang on 2020/3/17.
 * 0～n-1中缺失的数字
 */
public class 面试题53II {

    public int missingNumber(int[] nums) {
        int leftIndex = 0, rightIndex = nums.length - 1;
        while (leftIndex <= rightIndex) {
            int mid = (leftIndex + rightIndex) / 2;
            if (nums[mid] == mid)
                leftIndex = mid + 1;
            else if (nums[mid] > mid)
                rightIndex = mid - 1;
        }
        return leftIndex;
    }

}
