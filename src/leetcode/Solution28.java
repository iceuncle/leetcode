package leetcode;

public class Solution28 {

    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null)
            throw new IllegalArgumentException("haystack or needle cannot be null");
        if (needle.length() == 0)
            return 0;
        if (needle.length() > haystack.length())
            return -1;
        char[] haystackChars = haystack.toCharArray();
        char[] needleChars = needle.toCharArray();
        for (int i = 0; i < haystackChars.length; i++) {
            for (int j = 0; j < needleChars.length
                    && i + j < haystackChars.length; j++) {
                if (haystackChars[i + j] != needleChars[j])
                    break;
                if (j == needleChars.length - 1)
                    return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution28().strStr("hello", "ll"));
        System.out.println(new Solution28().strStr("aaaaa", "bba"));
        System.out.println(new Solution28().strStr("a", "a"));
        System.out.println(new Solution28().strStr("aaa", "aaaa"));
        System.out.println(new Solution28().strStr("mississippi", "issipi"));
    }

}
