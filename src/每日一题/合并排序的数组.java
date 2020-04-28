package 每日一题;

/**
 * <p>
 * Created by tianyang on 2020/3/6.
 * <p>
 * 给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。
 * <p>
 * 初始化 A 和 B 的元素数量分别为 m 和 n。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * A = [1,2,3,0,0,0], m = 3
 * B = [2,5,6],       n = 3
 * <p>
 * 输出: [1,2,2,3,5,6]
 * <p>
 * <p>
 * <p>
 * [2,0]
 * 1
 * [1]
 * 1
 * <p>
 * <p>
 * <p>
 * size 1
 * 0 0
 * <p>
 * size 0
 * [1, 2]
 * 0 -1
 * [2]
 */
public class 合并排序的数组 {

    public void merge(int[] A, int m, int[] B, int n) {
        int indexA = m - 1;
        int indexB = n - 1;
        while (indexB >= 0) {
            if (indexA < 0) {
                for (int i = 0; i <= indexB; i++) {
                    A[i] = B[i];
                }
                break;
            }
            if (A[indexA] >= B[indexB]) {
                A[indexA + indexB + 1] = A[indexA--];
            } else {
                A[indexA + indexB + 1] = B[indexB--];
            }
        }
    }

    public void merge1(int[] A, int m, int[] B, int n) {
        int index1 = m - 1;
        int index2 = n - 1;
        int size = m + n - 1;
        while (index1 >= 0 && index2 >= 0) {
            A[size--] = A[index1] >= B[index2] ? A[index1--] : B[index2--];
        }
        if (index2 >= 0) {
            for (int i = 0; i <= index2; i++) {
                A[i] = B[i];
            }
        }
    }

    public static void main(String[] args) {
        (new 合并排序的数组()).merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
    }


}
