package middle.t7_7;

import java.util.*;
import java.util.Scanner;

/**
 * 连通网络的操作次数
 */
public class Main {

    class UnionFind {
        int[] parent;
        int n;
        public UnionFind(int n) {
            this.n = n;
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        // 查找父节点
        public int find(int x) {
            if (x == parent[x]) {
                return x;
            }
            return parent[x] = find(parent[x]);
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                parent[rootX] = rootY;
            }
        }

        public boolean connected(int x, int y) {
            return find(x) == find(y);
        }

        public int rootCount() {
            Set<Integer> res = new HashSet<Integer>();
            for (int i = 0; i < n; i++) {
                res.add(find(i));
            }
            return res.size();
        }
    }

    public int n, m;

    public void input(Scanner scan) {
        n = scan.nextInt();
        m = scan.nextInt();
        if (m < n-1) {
            System.out.println("-1");
            return;
        }

        UnionFind uf = new UnionFind(n);
        for (int i =0; i < m; i++) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            uf.union(a, b);
        }

        System.out.println(uf.rootCount() - 1);
    }


    public static void main(String[] args) {
        new Main().input(new Scanner(System.in));
    }
}
