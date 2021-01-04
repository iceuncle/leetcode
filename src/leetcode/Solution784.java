package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution784 {

    public List<String> letterCasePermutation(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0) return res;
        char[] charArray = s.toCharArray();
        dfs(charArray, 0, res);
        return res;
    }

    private void dfs(char[] charArray, int index, List<String> res) {
        if (index == charArray.length) {
            res.add(new String(charArray));
            return;
        }
        dfs(charArray, index + 1, res);
        if (Character.isLowerCase(charArray[index])) {
            charArray[index] = Character.toUpperCase(charArray[index]);
            dfs(charArray, index + 1, res);
        } else if (Character.isUpperCase(charArray[index])) {
            charArray[index] = Character.toLowerCase(charArray[index]);
            dfs(charArray, index + 1, res);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution784().letterCasePermutation("a1b2"));
    }

}
