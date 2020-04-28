package 每日一题;

/**
 * <p>
 * Created by tianyang on 2020/3/11.
 */
public class 将数组分成和相等的三个部分 {
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for (int i : A)
            sum += i;
        if (sum % 3 != 0)
            return false;
        int target = 0;
        int index = 0;
        while (index < A.length) {
            target += A[index];
            if (target == sum / 3)
                break;
            index++;
        }
        index++;
        if (target != sum / 3)
            return false;
        while (index < A.length - 1) {
            target += A[index];
            if (target == sum / 3 * 2)
                return true;
            index++;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println((new 将数组分成和相等的三个部分())
                .canThreePartsEqualSum(new int[]{1, -1, 1, -1}));
    }
}
