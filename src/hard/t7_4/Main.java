package hard.t7_4;

import java.util.*;

/**
 * 最长递增子序列
 */
class Main {
    int[] nums;

    public void solve() {
        int n = nums.length;
        // dp[i] = 表示以i结尾，从0到i最长严格子序列的长度
        int[] dp = new int[n];
        int maxLen = 1;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        System.out.println(maxLen);
    }

    public Main input(Scanner scan) {
        nums = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        return this;
    }

    public static void main(String[] args) {
        new Main().input(new Scanner(System.in)).solve();
    }
}