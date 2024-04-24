package easy.t7_13;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 求最后一块石头的重量
 */
public class Main {

    int[] arr;

    // 该问题可以理解为将数组分为两组，使其和的差值最小
    // 动态规划： dp[j] 表示 是否可以从输入中选取一个集合使其差值和最小
    void computeUseDp() {
        int sum = Arrays.stream(arr).sum();
        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int i = 0; i < target + 1; i++) {
            for (int a : arr) {
                if (i + a <= target) {
                    dp[i + a] = true;
                }
            }
        }
        int ind = target;
        while (dp[ind] == false) {
            ind--;
        }
        int res = sum - 2 * target;
        System.out.println(res);
    }

    // 用最大堆
    void computeHeap() {
        PriorityQueue<Integer> que = new PriorityQueue<Integer>(Comparator.reverseOrder());
        que.addAll(Arrays.stream(arr).boxed().collect(Collectors.toList()));
        while (que.size() > 1) {
            int a = que.poll();
            int b = que.poll();
            que.add(Math.abs(a-b));
        }
        System.out.println(que.poll());
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.arr = Arrays.stream(new Scanner(System.in).nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
//        main.computeUseDp();
        main.computeHeap();
    }
}
