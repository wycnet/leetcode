package hard.t7_8;

import java.util.*;

/**
 * 解码异或后的排列
 */
class Main {

    public int[] encoded;
    int n;
    public int[] perm;

    public void solve() {
        int total = 0;
        for (int i = 1; i <= n ; i++) {
            total ^= i;
        }
        int all = 0;
        for (int i = 1; i < n - 1; i += 2) {
            all ^= encoded[i];
        }
        perm[0] = all ^ total;
        for (int i = 1; i < n; i++) {
            perm[i] = perm[i-1] ^ encoded[i-1];
        }

        String result = String.join(",", Arrays.stream(perm).mapToObj(String::valueOf).toArray(String[]::new));
        System.out.println(result);
    }

    public Main input(Scanner scan) {
        encoded = Arrays.stream(scan.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        n = encoded.length + 1;
        perm = new int[n];
        return this;
    }

    public static void main(String[] args) {
        new Main().input(new Scanner(System.in)).solve();
    }
}
