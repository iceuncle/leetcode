package leetcode;

public class Solution134 {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length, i = 0;
        while (i < n) {
            int sumOfGas = 0;
            int sumOfCost = 0;
            int count = 0;
            while (count < n) {
                int j = (i + count) % n;
                sumOfGas += gas[j];
                sumOfCost += cost[j];
                if (sumOfCost > sumOfGas)
                    break;
                count++;
            }
            if (count == n) return i;
            else i = i + count + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
//        System.out.println(new Solution134().canCompleteCircuit(new int[]{1, 2, 3, 4, 5},
//                new int[]{3, 4, 5, 1, 2}));
        System.out.println(new Solution134().canCompleteCircuit(new int[]{4, 2, 3, 3},
                new int[]{3, 3, 4, 4}));
    }

}
