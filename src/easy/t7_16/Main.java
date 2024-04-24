package easy.t7_16;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 给定数字组成最大时间
 */
public class Main {
    int[] nums = new int[4];
    boolean[] hasChoose = new boolean[4];
    int[] res = new int[4];

    void compute() {
        // 24 小时制，第一位不大于2， 第二位不大于4， 第三位不大于6， 第四位不大于 9
        // 其中第三位如果为6，那么第4位必须为0
        res[0] = findMax(2);
        res[1] = findMax((res[0] == 2) ? 3 : 9);
        res[2] = findMax(5);
        res[3] = findMax(9);

        System.out.println(res[0] + "" + res[1] + ":" + res[2] + "" + res[3]);
    }

    private int findMax(int max) {
        int res = -1;
        int ind = 0;
        for (int i = 0; i < 4; i++) {
            if (nums[i] <= max && nums[i] >= res && !hasChoose[i]) {
                res = nums[i];
                ind = i;
            }
        }
        hasChoose[ind] = true;
        return res;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Main main = new Main();
        main.nums = Arrays.stream(scan.nextLine().split(",")).mapToInt(Integer::parseInt).sorted().toArray();
        main.compute();
    }
}
