package leetcode;

public class Solution11 {

    /**
     * [1,8,6,2,5,4,8,3,7]
     * 0 1
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int res = 0;
        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            res = Math.max(res, area);
            if (height[left] < height[right])
                left++;
            else
                right--;
        }
        return res;
    }

}
