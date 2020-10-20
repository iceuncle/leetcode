package leetcode;

import java.util.HashSet;
import java.util.Set;

public class Solution929 {

    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            String prefix = email.split("@")[0];
            String domain = email.split("@")[1];
            if (prefix.contains("+"))
                prefix = prefix.split("\\+")[0];
            if (prefix.contains("."))
                prefix = prefix.replaceAll("\\.", "");
            set.add(prefix + "@" + domain);
        }
        return set.size();
    }

    public static void main(String[] args) {
        String[] strings = new String[]{"test.email+alex@leetcode.com",
                "test.e.mail+bob.cathy@leetcode.com",
                "testemail+david@lee.tcode.com"};
        int size = new Solution929().numUniqueEmails(strings);
        System.out.println(size);
    }
}
