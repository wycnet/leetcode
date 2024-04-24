package easy.t7_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 合作圈
 */
public class Main {

    ArrayList<ArrayList<Integer>> map = new ArrayList<>();
    int size;
    boolean[] inCycle;

    public int computeCount() {
        int res = 0;
        for (int i = 0; i < size; i++) {
            if (inCycle[i] == false) {
                inCycle[i] = true;
                res ++;
                dfs(i);
            }
        }
        return res;
    }

    private void dfs(int i) {
        for (int j = 0; j< size; j++) {
            if (inCycle[j] || j == i) {
                continue;
            }
            if (map.get(i).get(j) == 1) {
                inCycle[j] = true;
                dfs(j);
            }
        }
    }


    public static void main(String[] args) {
        Main squre = new Main();
        Scanner scan = new Scanner(System.in);
        String[] inputLines = scan.nextLine().trim().split("\\|");
        squre.size = inputLines.length;
        squre.inCycle = new boolean[inputLines.length];
        Arrays.fill(squre.inCycle, false);
        for (int i = 0; i < inputLines.length; i++) {
            String[] singleLine = inputLines[i].trim().split(" ");
            squre.map.add(new ArrayList<Integer>());
            for (int j = 0; j < singleLine.length; j++) {
                int x = Integer.parseInt(singleLine[j]);
                squre.map.get(i).add(x);
            }
        }
        System.out.print(squre.computeCount());
    }
}
