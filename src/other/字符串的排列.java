package other;

import java.util.*;

public class 字符串的排列 {

    public String[] permutation(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0) return res.toArray(new String[0]);
        char[] charArray = s.toCharArray();
        Arrays.sort(charArray);
        boolean[] used = new boolean[charArray.length];
        backTracking(charArray, 0, new StringBuilder(), res, used);
        return res.toArray(new String[0]);
    }

    private void backTracking(char[] charArray, int index, StringBuilder path,
                              List<String> res, boolean[] used) {
        if (index == charArray.length) {
            res.add(path.toString());
            return;
        }
        for (int i = 0; i < charArray.length; i++) {
            if (used[i] || (i > 0 && charArray[i] == charArray[i - 1] && used[i - 1])) {
                continue;
            }
            path.append(charArray[i]);
            used[i] = true;
            backTracking(charArray, index + 1, path, res, used);
            path.deleteCharAt(path.length() - 1);
            used[i] = false;
        }
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(new 字符串的排列().permutation("abc")));
    }


}
