package 算法初级.其他;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * Created by tianyang on 2020/3/11.
 * <p>
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * <p>
 * 1
 * 1 1
 * 1 2 1
 * 1 3 3 1
 */
public class 帕斯卡三角形 {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (numRows == 0) return ret;
        ret.add(new ArrayList<>());
        ret.get(0).add(1);

        for (int i = 1; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            List<Integer> preList = ret.get(i - 1);
            for (int j = 1; j < i; j++) {
                list.add(preList.get(j - 1) + preList.get(j));
            }
            list.add(1);
            ret.add(list);
        }
        return ret;
    }

}
