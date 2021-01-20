package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 复原IP地址
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 * <p>
 * 有效的 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 * <p>
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效的 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效的 IP 地址。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/restore-ip-addresses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 输入：s = "25525511135"
 * 输出：["255.255.11.135","255.255.111.35"]
 * 输入：s = "0000"
 * 输出：["0.0.0.0"]
 */
public class Solution93 {

    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        Stack<String> path = new Stack<>();
        backTracking(s, 0, 4, path, res);
        return res;
    }

    /**
     * @param s      字符串
     * @param begin  当前处理的字符串位置
     * @param count  剩余多少段
     * @param path   路径
     * @param result 结果
     */
    public void backTracking(String s, int begin, int count, Stack<String> path, List<String> result) {
        if (begin == s.length()) {
            if (count == 0) {
                result.add(String.join(".", path));
            }
            return;
        }
        for (int i = begin; i < begin + 3 && i < s.length(); i++) {
            //如果剩余字符长度大于剩余段*3 剪枝
            if (s.length() - i - 1 > (count - 1) * 3)
                continue;
            int num = Integer.parseInt(s.substring(begin, i + 1));
            //如果数值大于255， 剪枝
            if (num > 255)
                continue;
            //如果存在01.001.01.01这种情况 剪枝
            if (String.valueOf(num).length() != i + 1 - begin)
                continue;
            path.add(String.valueOf(num));
            backTracking(s, i + 1, count - 1, path,     result);
            path.pop();
        }
    }


    public static void main(String[] args) {
        Solution93 solution = new Solution93();
        System.out.println(solution.restoreIpAddresses("25525511135"));
    }

}
