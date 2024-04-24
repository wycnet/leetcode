package hard.t7_13;

import java.util.*;

/**
 * 最多能完成排序的块
 */
class Main {

    int[] arr;

    // 简单容易理解的方法
    // 左段的最大值小于右段的最小值
    public void solve() {
        int[] ldp = new int[arr.length];
        int[] rdp = new int[arr.length];

        // 左侧最大值
        ldp[0] = arr[0];
        for (int i = 1; i < ldp.length; i++) {
            ldp[i] = Math.max(ldp[i-1], arr[i]);

        }
        // 右侧最小值
        rdp[arr.length - 1] = arr[arr.length - 1];
        for (int j = rdp.length - 2; j >= 0; j--) {
            rdp[j] = Math.min(rdp[j+1], arr[j]);
        }

        int res = 1;
        for (int i = 1; i < arr.length; i++) {
            if (ldp[i-1] <= rdp[i]) {
                // System.out.println(i+" "+ldp[i-1]+" "+rdp[i]);
                res++;
            }
        }
        System.out.println(res);

    }

    public Main input(Scanner scan) {
        arr = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        return this;
    }


    public static void main(String[] srgs) {
        new Main().input(new Scanner(System.in)).solve();
    }
}