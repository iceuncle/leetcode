package 剑指offer;

import java.util.Arrays;

/**
 * <p>
 * Created by tianyang on 2020/3/17.
 * 翻转单词顺序
 */
public class 面试题58I {

    public String reverseWords(String s) {
        String[] strings = s.split(" ");
        StringBuilder res = new StringBuilder();
        for (int i = strings.length - 1; i >= 0; i--) {
            if (!strings[i].equals("")) {
                res.append(strings[i]);
                res.append(" ");
            }
        }
        return res.toString().trim();
    }

    public static void main(String[] args) {
        String[] strings = "  hello  world!  ".split(" ");
        System.out.println(Arrays.toString(strings));
    }
}
