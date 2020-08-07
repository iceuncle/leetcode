package leetcode;

/**
 * <p>
 * Created by tianyang on 2020/3/5.
 * 分糖果 II
 * 排排坐，分糖果。
 * <p>
 * 我们买了一些糖果 candies，打算把它们分给排好队的 n = num_people 个小朋友。
 * <p>
 * 给第一个小朋友 1 颗糖果，第二个小朋友 2 颗，依此类推，直到给最后一个小朋友 n 颗糖果。
 * <p>
 * 然后，我们再回到队伍的起点，给第一个小朋友 n + 1 颗糖果，第二个小朋友 n + 2 颗，依此类推，直到给最后一个小朋友 2 * n 颗糖果。
 * <p>
 * 重复上述过程（每次都比上一次多给出一颗糖果，当到达队伍终点后再次从队伍起点开始），直到我们分完所有的糖果。注意，就算我们手中的剩下糖果数不够（不比前一次发出的糖果多），这些糖果也会全部发给当前的小朋友。
 * <p>
 * 返回一个长度为 num_people、元素之和为 candies 的数组，以表示糖果的最终分发情况（即 ans[i] 表示第 i 个小朋友分到的糖果数）
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/distribute-candies-to-people
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution1103 {
    public int[] distributeCandies(int candies, int num_people) {
        int[] ret = new int[num_people];
        int n = (int) (Math.sqrt(candies * 2 + 0.25) - 0.5);
        System.out.println(((Math.sqrt(candies * 2 + 0.25)) - 0.5));
        System.out.println(n);
        int last = candies - (1 + n) * n / 2;
        System.out.println(last);
        for (int i = 1; i <= n; i++) {
            ret[(i - 1) % num_people] += i;
        }
        if (last > 0)
            ret[n % num_people] += last;
        return ret;
    }

    public int[] distributeCandies1(int candies, int num_people) {
        int[] ret = new int[num_people];
        int i = 1;
        while (candies > 0) {
            if (i < candies)
                ret[(i - 1) % num_people] += i;
            else
                ret[(i - 1) % num_people] += candies;
            candies = candies - i;
            i++;
        }
        return ret;
    }

    public int[] distributeCandies2(int candies, int num_people) {
        int[] res = new int[num_people];
        int count = 1;
        int index = 0;
        while (candies - count > 0) {
            res[index % num_people] += count;
            candies = candies - count;
            index++;
            count++;
        }
        if (candies > 0)
            res[index % num_people] += candies;
        return res;
    }

    public static void main(String[] args) {
        System.out.println((int) Math.sqrt(15));
    }
}
