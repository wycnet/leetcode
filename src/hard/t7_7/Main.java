package hard.t7_7;

import java.util.*;

/**
 * 不相交的线
 */
class Main {
    int[] nums1;
    int[] nums2;


    private void solve() {
        // dp表示以 i,j 结尾的的最大数量
        int[][] dp = new int[nums1[0]+1][nums2[0]+1];
        int len1 = nums1[0] + 1;
        int len2 = nums2[0] + 1;
        for (int i = 1; i < len1; i++) {
            for (int j = 1; j < len2; j++) {
                if (nums1[i] == nums2[j]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        System.out.println(dp[len1 -1][len2 -1]);
    }

    public void input(Scanner scan) {
        while (scan.hasNext()) {
            nums1 = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            nums2 = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            solve();
        }
    }

    public static void main(String[] args) {
        new Main().input(new Scanner(System.in));
    }
}
