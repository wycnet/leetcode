package easy.t7_18;

import java.util.Scanner;

/**
 * 最长回文子串
 */
public class Main {

    // ------中心扩散法----------
    String originStr = null;

    public String startCenterSpr(String input) {
        originStr = input;
        int[] maxPair = new int[]{0, 0};
        for (int i = 0; i < originStr.length(); i++) {
            int[] pair1 = compute(i, i);
            int[] pair2 = compute(i, i + 1);
            int[] temp = (pair1[1] - pair1[0] > pair2[1] - pair2[0]) ? pair1 : pair2;
            maxPair = (maxPair[1] - maxPair[0] > temp[1] - temp[0]) ? maxPair : temp;
        }
        return originStr.substring(maxPair[0], maxPair[1] + 1);
    }


    private int[] compute(int start, int end) {
        while (start >= 0 && end < originStr.length() && originStr.charAt(start) == originStr.charAt(end)) {
            start--;
            end++;
        }
        return new int[]{start + 1, end - 1};
    }
    // ----------------------------

    // ---------动态规划-------------
    // dp[i][j] 代表从字符i到字符j是回文
    public String startDp(String input) {
        int size = input.length();
        boolean[][] dp = new boolean[size][size];
        int start = 0, end = 0;
        for (int i = 0; i < size; i++) {
            dp[i][i] = true;
            for (int j = 0; j < i; j++) {
                if (( (i-j < 2) || dp[i - 1][j + 1]) && input.charAt(i) == input.charAt(j)) {
                    dp[i][j] = true;
                    if (i - j > end - start) {
                        end = i;
                        start = j;
                    }
                }

            }
        }
        return input.substring(start, end + 1);
    }

    //-----------------------------


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
//        String res = new Main().startCenterSpr(scan.nextLine());
        String res = new Main().startDp(scan.nextLine());
        System.out.println(res);
    }
}
