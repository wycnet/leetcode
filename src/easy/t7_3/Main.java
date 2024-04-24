package easy.t7_3;

import java.util.Scanner;

/**
 * 大山的数目
 */
public class Main {
    int m, n;
    int[][] mapMatrix;

    public Main input(Scanner scan) {
        m = scan.nextInt();
        n = scan.nextInt();
        mapMatrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                mapMatrix[i][j] = scan.nextInt();
            }
        }
        return this;
    }

    void compute() {
        int mountainCount = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mapMatrix[i][j] == 1) {
                    mountainCount++;
                    dfs(i, j);
                }
            }
        }
        System.out.println(mountainCount);
    }

    private void dfs(int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || mapMatrix[i][j] == 0) {
            return;
        }
        mapMatrix[i][j] = 0;
        dfs(i - 1, j);
        dfs(i + 1, j);
        dfs(i, j - 1);
        dfs(i, j + 1);
    }

    public static void main(String[] args) {
        new Main().input(new Scanner(System.in)).compute();
    }

}