package hard.t7_2;

import java.util.*;

/**
 * 按公因数计算最大组件大小
 */
public class Main{

    int[] nums;
    int max;
    private boolean debug = false;

    public static class UnionFind {
        int[] root;

        public UnionFind(int m) {
            root = new int[m];
            for (int i = 0; i < m; i++) {
                root[i] = i;
            }
        }

        public int find(int x) {
            if (root[x] == x) {
                return x;
            }
            return root[x] = find(root[x]);
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                root[rootX] = rootY;
            }
        }
    }

    public void solve() {
        if (debug) {
            System.out.println("tart solve");
        }
        UnionFind uf = new UnionFind(max + 1);
        for (int num : nums) {
            for (int i = 2; i*i <= num; i++) {
                if (num % i == 0) {
                    uf.union(num, i);
                    uf.union(num/i, i);
                }
            }
        }
        // 计算最大值
        int[] count = new int[max + 1];
        for (int x: nums) {
            count[uf.find(x)]++;
        }
        if (debug) {
            System.out.println("out debug");
            System.out.println(Arrays.toString(count));
        }
        int res = Arrays.stream(count).max().getAsInt();
        System.out.print(res);
    }

    public Main intput(Scanner scan) {
        nums = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        max = Arrays.stream(nums).max().getAsInt();
        return this;
    }

    public static void main(String[] args) {
        new Main().intput(new Scanner(System.in)).solve();
    }
}
