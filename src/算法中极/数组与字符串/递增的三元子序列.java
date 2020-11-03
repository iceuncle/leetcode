package 算法中极.数组与字符串;

public class 递增的三元子序列 {

    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) return false;
        int small = Integer.MAX_VALUE, mid = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= small)
                small = num;
            else if (num <= mid)
                mid = num;
            else
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new 递增的三元子序列().increasingTriplet(new int[]{1, 2, 0, 4}));
    }

}
