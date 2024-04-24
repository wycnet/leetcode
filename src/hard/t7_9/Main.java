package hard.t7_9;

import java.util.*;


/**
 * 最长超赞子字符串
 */
class Main {
    String s;


    // 回文串中每个字符个数是偶数个或者有一个字符是奇数个
    // 用二进制1表示奇数个，0表示偶数个
    // 用10位二进制表示所有字符出现的奇偶性
    // dp[i] 表示s中0~i中各个字符出现的奇偶性
    // dp[j] == dp[j] 或者 dp[j] 和 dp[i] 差了一位，
    // 说明i~j是超赞回文子串
    public void solve() {
        int[] dp = new int[s.length()+1];
        int res = 1;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = dp[i - 1] ^ (1 << (s.charAt(i-1) - '0'));
            for (int j = 0; j < i; j++) {
                if (dp[j] == dp[i]) {
                    int len = i - j;
                    res = Math.max(len, res);
                } else {
                    int n = dp[i] ^ dp[j];
                    int oneCount = 0;
                    for (int x = 0; x < 10; x++) {
                        if ((n & 1) == 1) {
                            oneCount++;
                        }
                        n = n >> 1;
                    }
                    if (oneCount == 1) {
                        int len = i - j;
                        res = Math.max(len, res);
                    }
                }
            }
        }
        System.out.println(res);
    }


    public Main intput(Scanner scan) {
        s = scan.next();
        return this;
    }

    public static void main(String[] args) {
        new Main().intput(new Scanner(System.in)).solve();
    }
}
