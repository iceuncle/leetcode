package leetcode;

public class Solution466 {

    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        int count = 0, index = 0;
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < s1.length(); j++) {
                if (s2.charAt(index) == s1.charAt(j)) {
                    index++;
                }
                if (index == s2.length()) {
                    index = 0;
                    count++;
                }
            }
        }
        return count / n2;
    }

}
