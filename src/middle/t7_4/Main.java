package middle.t7_4;

import java.util.*;

/**
 *  钥匙和房间
 */
public class Main {
    int n;
    boolean[] visited;
    ArrayList<ArrayList<String>> rooms;

    public void compute() {
        dfs(0);
        String res = "true";
        for (int i =0; i<n; i++) {
            if (visited[i] == false) {
                res = "false";
                break;
            }
        }
        System.out.print(res);
    }

    private void dfs(int number) {
        if (visited[number]) {
            return;
        }
        visited[number] = true;
        ArrayList<String> rl = rooms.get(number);
        for (int i = 0; i < rl.size(); i++) {
            if (rl.get(i).isEmpty()) {
                continue;
            }
            int nextNumber = Integer.parseInt(rl.get(i));
            dfs(nextNumber);
        }
    }

    public Main input(Scanner scan) {
        String input = scan.nextLine();
        String[] lines = input.substring(1, input.length() - 1).split(";");
        rooms = new ArrayList<>();
        for (int i =0; i< lines.length; i++) {
            String s = lines[i];
            String singeLine = s.substring(1, s.length() - 1);
            ArrayList<String> troom = new ArrayList();
            String[] subLines = singeLine.split(",");
            for (int j =0; j < subLines.length; j++) {
                troom.add(subLines[j]);
            }
            rooms.add(troom);
        }
        n = rooms.size();
        visited = new boolean[n];
        // printArray();
        return this;
    }

    private void printArray() {
        for (int i=0; i< rooms.size(); i++) {
            ArrayList<String> rl = rooms.get(i);
            for (int j =0; j< rl.size(); j++) {
                System.out.print(rl.get(j)+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] arg) {
        new Main().input(new Scanner(System.in)).compute();
    }
}
