package hard.t7_10;

import java.util.*;

/**
 * 统计美丽子字符串 II
 */
class Main {
    String s;
    int k;
    String yun;

    public void solve() {
        // dp[i] i个字符中元音字母数量
        int[] dp = new int[s.length() + 1];
        int res = 0;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = dp[i-1];
            if (yun.indexOf(s.charAt(i - 1)) >= 0){
                dp[i]++;
            }
            for(int j = 0; j < i; j++) {
                int count = dp[i] - dp[j];
                int total = i - j;
                if ( (total - count == count)
                        && ((total - count) * count) % k == 0
                ) {
                    res++;
                }
            }
        }
        System.out.println(res);
    }

    public Main input(Scanner scan) {
        scan.next();
        scan.next();
        s = scan.next();
        s = s.substring(1, s.length()-2);
        scan.next();
        scan.next();
        k = scan.nextInt();
        yun = "aeiou";
        return this;
    }

    public static void main(String[] args) {
        new Main().input(new Scanner(System.in)).solve();
    }
}
