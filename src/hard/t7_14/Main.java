package hard.t7_14;

import java.util.*;

/**
 * 异次元星人的文字
 */
class Main {

    public void solve(String s) {
        int maxLen = 0;
        for (int i = 1; i < s.length(); i++) {
            maxLen = Math.max(maxLen, maxStr(s, i, i));
            maxLen = Math.max(maxLen, maxStr(s, i - 1, i));
        }
        if (maxLen < 3) {
            maxLen = 0;
        }
        System.out.println(maxLen);
    }

    public int maxStr(String s, int start, int end) {
        boolean hasLittter = false;
        while (
                start >= 0 && end < s.length()
                        && s.charAt(start) == s.charAt(end)
        ) {
            if (s.charAt(start) >= 'A' || s.charAt(end) >= 'A') {
                hasLittter = true;
            }
            start--;
            end++;
        }
        if (hasLittter == false) {
            return 0;
        }
        return end - start - 1;
    }


    public void input(Scanner scan) {
        while (scan.hasNext()) {
            solve(scan.next());
        }
    }

    public static void main(String[] args) {
        new Main().input(new Scanner(System.in));
    }
}