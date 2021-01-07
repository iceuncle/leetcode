package leetcode;

public class Solution38 {

    public String countAndSay(int n) {
        String s = "";
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                s = "1";
                continue;
            }
            int num = 1;
            char c = s.charAt(0);
            StringBuilder builder = new StringBuilder();
            for (int j = 1; j < s.length(); j++) {
                if (s.charAt(j) == c) {
                    num++;
                } else {
                    builder.append(num).append(c);
                    c = s.charAt(j);
                    num = 1;
                }
            }
            builder.append(num).append(c);
            s = builder.toString();
        }
        return s;
    }
}
