package hard.t7_11;

import java.util.*;

/**
 * 判断二分图
 */
class Main {

    int[] colors; // 0 未知； 1红色； 2绿色
    ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
    boolean solved = true;

    public void solve() {
        int n = arr.size();
        for (int i = 0; i< n; i++) {
            if (solved == false) {
                break;
            }
            if (colors[i] == 0) {
                dfs(i, 1);
            }

        }
        if (solved) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

    public void dfs(int i, int color) {
        if (colors[i] == color || solved == false) {
            return;
        }
        if (colors[i] != 0 && colors[i] != color) {
            solved = false;
            return;
        }
        colors[i] = color;
        int nextColor = 1;
        if (color == 1) {
            nextColor = 2;
        }
        for (int x : arr.get(i)) {
            dfs(x, nextColor);
        }
    }

    public Main input(Scanner scan) {
        String inp = scan.nextLine();
        inp = inp.substring(1, inp.length()-1);
        String[] lines = inp.split(";");
        for (String line : lines) {
            String s = line.substring(1, line.length() - 1);
            String[] ls = s.split(",");
            ArrayList<Integer> l = new ArrayList<>();
            for (String v : ls) {
                l.add(Integer.valueOf(v));
            }
            arr.add(l);
        }
        colors = new int[arr.size()];

        return this;
    }


    public static void main(String[] args) {
        new Main().input(new Scanner(System.in)).solve();
    }
}