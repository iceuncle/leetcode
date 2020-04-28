package 剑指offer;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * Created by tianyang on 2020/3/16.
 * 从尾到头打印链表
 */
public class 面试题06 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public int[] reversePrint(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode temp = head;
        while (temp != null) {
            list.add(temp.val);
            temp = temp.next;
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(res.length - 1 - i);
        }
        return res;
    }

}
