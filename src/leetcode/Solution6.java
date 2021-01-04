package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Z 字形变换
 */
public class Solution6 {

    public String convert(String s, int numRows) {
        if(numRows < 2) return s;
        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }
        int line = 0, flag = -1;
        for (Character c : s.toCharArray()) {
            list.get(line).append(c);
            if (line == 0 || line == numRows - 1)
                flag = -flag;
            line += flag;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder row: list) {
            res.append(row);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution6().convert("LEETCODEISHIRING", 3));
    }

}
