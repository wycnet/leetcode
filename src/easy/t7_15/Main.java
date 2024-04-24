package easy.t7_15;

import java.util.Scanner;

/**
 * 字符串编辑距离
 */
public class Main {
    private int[][] dp;
    private String s1;
    private String s2;

    public Main input(Scanner scan) {
        String[] in = scan.nextLine().split(" ");
        s1 = in[0];
        s2 = in[1];
        dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i < s1.length() + 1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j < s2.length() + 1; j++) {
            dp[0][j] = j;
        }
        return this;
    }

    // dp[i][j] 代表 s1前i个与s2前j个之间的距离
    public void compute() {
        for (int i = 1; i < s1.length() + 1; i++) {
            for (int j = 1; j < s2.length() + 1; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }
        System.out.println(dp[s1.length()][s2.length()]);
    }

    public static void main(String[] args) {
        new Main().input(new Scanner(System.in)).compute();
    }
}
