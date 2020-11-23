package 算法中极.数学;

public class Excel表列序号 {

    // 98789
    public int titleToNumber(String s) {
        int res = 0;
        while (s.length() > 0) {
            char c = s.charAt(0);
            res = res * 26 + getInt(c);
            s = s.substring(1);
        }
        return res;
    }

    public int getInt(char c) {
        return c - 'A' + 1;
    }

    public int titleToNumber1(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res = res * 26 + s.charAt(i) - 'A' + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Excel表列序号().titleToNumber1("ZY"));
    }

}
