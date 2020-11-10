package 算法中极.回溯算法;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class 电话号码的字母组合 {

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) return res;
        HashMap<Character, String> map = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        backTracking(digits, map, 0, new StringBuilder(), res);
        return res;
    }

    public void backTracking(String digits, HashMap<Character, String> map,
                             int index, StringBuilder stringBuilder, List<String> res) {
        if (index == digits.length()) {
            res.add(stringBuilder.toString());
            return;
        }
        Character digit = digits.charAt(index);
        String letter = map.get(digit);
        for (int i = 0; i < letter.length(); i++) {
            stringBuilder.append(letter.charAt(i));
            backTracking(digits, map, index + 1, stringBuilder, res);
            stringBuilder.deleteCharAt(index);
        }
    }

    public static void main(String[] args) {
        System.out.println(new 电话号码的字母组合().letterCombinations("234"));
    }

}
