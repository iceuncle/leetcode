package leetcode;

/**
 * 矩形重叠
 * <p>
 * 矩形以列表 [x1, y1, x2, y2] 的形式表示，其中 (x1, y1) 为左下角的坐标，(x2, y2) 是右上角的坐标。
 * <p>
 * 如果相交的面积为正，则称两矩形重叠。需要明确的是，只在角或边接触的两个矩形不构成重叠。
 * <p>
 * 给出两个矩形，判断它们是否重叠并返回结果。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：rec1 = [0,0,2,2], rec2 = [1,1,3,3]
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：rec1 = [0,0,1,1], rec2 = [1,0,2,1]
 * 输出：false
 */
public class Solution836 {

    // 投影相交
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int rec1x1 = rec1[0], rec1y1 = rec1[1], rec1x2 = rec1[2], rec1y2 = rec1[3];
        int rec2x1 = rec2[0], rec2y1 = rec2[1], rec2x2 = rec2[2], rec2y2 = rec2[3];
        boolean isX = false;
        if (rec1x1 <= rec2x1)
            isX = rec1x2 > rec2x1;
        else
            isX = rec2x2 > rec1x1;
        boolean isY = false;
        if (rec1y1 <= rec2y1)
            isY = rec1y2 > rec2y1;
        else
            isY = rec2y2 > rec1y1;
        return isX && isY;
    }

    //投影相交优化
    public boolean isRectangleOverlap1(int[] rec1, int[] rec2) {
        int rec1x1 = rec1[0], rec1y1 = rec1[1], rec1x2 = rec1[2], rec1y2 = rec1[3];
        int rec2x1 = rec2[0], rec2y1 = rec2[1], rec2x2 = rec2[2], rec2y2 = rec2[3];
        return Math.max(rec1x1, rec2x1) < Math.min(rec1x2, rec2x2) &&
                Math.max(rec1y1, rec2y1) < Math.min(rec1y2, rec2y2);
    }


    //第二个矩形在第一个矩形的上下左右就不相交
    public boolean isRectangleOverlap2(int[] rec1, int[] rec2) {
        int rec1x1 = rec1[0], rec1y1 = rec1[1], rec1x2 = rec1[2], rec1y2 = rec1[3];
        int rec2x1 = rec2[0], rec2y1 = rec2[1], rec2x2 = rec2[2], rec2y2 = rec2[3];

        return !((rec2y1 >= rec1y2) || (rec2x1 >= rec1x2) || (rec2y2 <= rec1y1) || (rec2x2 <= rec1x1));
    }
}
