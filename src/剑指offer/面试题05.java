package 剑指offer;

/**
 * <p>
 * Created by tianyang on 2020/3/16.
 * 替换空格
 */
public class 面试题05 {

    public String replaceSpace(String s) {
        return s.replaceAll(" ", "%20");
    }

    public String replaceSpace1(String s) {
        StringBuilder builder = new StringBuilder();
        for (Character character : s.toCharArray()) {
            if (character.equals(' '))
                builder.append("%20");
            else
                builder.append(character);
        }
        return builder.toString();
    }

}
