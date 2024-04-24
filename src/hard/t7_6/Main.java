package hard.t7_6;

import java.util.*;

/**
 * 计算岛屿最大面积
 */
class Main {

    int[][] map;
    int rows;
    int cols;
    boolean debug = false;

    int maxArea = 0;
    public void solve() {
        for (int i =0; i< map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 1) {
                    maxArea = Math.max(maxArea, dfs(i,j));
                }
                dfs(i, j);
            }
        }
        System.out.println(maxArea);
    }

    private int dfs(int i, int j) {
        if (i < 0 || i >=  rows || j < 0 || j >= cols) {
            return 0;
        }
        if (map[i][j] == 0) {
            return 0;
        }
        map[i][j] = 0;
        return 1 + dfs(i - 1, j) + dfs(i + 1, j) + dfs(i, j - 1) + dfs(i, j + 1);
    }

    public Main input(Scanner scan) {
        String inp = scan.nextLine();
        String[] lines = inp.substring(1, inp.length() - 1).split(";");
        rows = lines.length;
        cols = (lines[0].length() - 1) / 2;
        map = new int[rows][cols];
        for (int i = 0; i < lines.length; i++) {
            String[] subLines = lines[i].substring(1, lines[i].length() - 1).split(",");
            for (int j = 0; j < subLines.length; j++) {
                map[i][j] = Integer.parseInt(subLines[j]);
            }
        }
        if (debug) {
            for (int i = 0; i < rows; i++) {
                System.out.println(Arrays.toString(map[i]));
            }

        }
        return this;
    }

    public static void main(String[] args) {
        new Main().input(new Scanner(System.in)).solve();
    }
}