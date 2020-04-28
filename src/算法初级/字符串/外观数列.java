package 算法初级.字符串;

/**
 * <p>
 * Created by tianyang on 2020/3/4.
 * <p>
 * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。前五项如下：
 * <p>
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 被读作  "one 1"  ("一个一") , 即 11。
 * 11 被读作 "two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 * <p>
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出外观数列的第 n 项。
 * <p>
 * 注意：整数序列中的每一项将表示为一个字符串。
 */
public class 外观数列 {

    public String countAndSay(int n) {
        String s = "";
        for (int i = 1; i <= n; i++) {
            if (i == 1) s = "1";
            else {
                StringBuilder stringBuilder = new StringBuilder();
                char c = s.charAt(0);
                int num = 1;
                for (int j = 1; j < s.length(); j += 1) {
                    if (s.charAt(j) == c) {
                        num += 1;
                    } else {
                        stringBuilder.append(num).append(c);
                        c = s.charAt(j);
                        num = 1;
                    }
                }
                stringBuilder.append(num).append(c);
                s = stringBuilder.toString();
            }
        }
        return s;
    }

}
