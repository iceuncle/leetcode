package 算法初级.数组;

/**
 * <p>
 * Created by tianyang on 2020/3/3.
 * <p>
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,1, 3, 0,0,12]
 * <p>           i
 * i                 j
 * j
 * <p>
 * 输出: [1, 1, 3,12,0,0]
 * 说明:
 * <p>
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 */
public class 移动零 {

    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0)
            return;
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
//            if (nums[j] != 0) {
//                if (i != j) {
//                    nums[i] = nums[j];
//                    nums[j] = 0;
//                }
//                i++;
//            }

            if (nums[i] != 0 && i == j) {
                i++;
            } else if (nums[j] != 0) {
                nums[i] = nums[j];
                nums[j] = 0;
                i++;
            }
        }

    }

}
