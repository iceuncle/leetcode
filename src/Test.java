import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * <p>
 * Created by tianyang on 2020/3/12.
 */
public class Test {

    public static void main(String[] args) {
        //冒泡
        int[] nums = new int[]{1, 3, 9, 0, 2, 4};
        for (int i = 0; i < nums.length; i++) {
            boolean isSwap = false;
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    isSwap = true;
                }
            }
            if (!isSwap)
                break;
        }
        System.out.println(Arrays.toString(nums));

        //选择
        for (int i = 0; i < nums.length; i++) {
            int minIndex = i;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
                int temp = nums[minIndex];
                nums[minIndex] = nums[i];
                nums[i] = temp;
            }
        }
        System.out.println(Arrays.toString(nums));

        //插入
        for (int i = 1; i < nums.length; i++) {
            int current = nums[i];
            int currentIndex = i;
            while (currentIndex - 1 >= 0 && current < nums[currentIndex - 1]) {
                nums[current] = nums[currentIndex - 1];
                currentIndex--;
            }
            nums[currentIndex] = current;
        }
        System.out.println(Arrays.toString(nums));


    }

}
