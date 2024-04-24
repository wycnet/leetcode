package middle.t7_2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 或运算的最小翻转次数
 */
public class Main {

    int a, b, c;

    public int compute() {
        int resStep = 0;
        int x = a, y = b, z = c;
        while (x != 0 || y != 0 || z != 0) {
            int sum = x % 2 + y % 2;
            int t = z % 2;
            if (sum == 0) {
                if (t == 1) {
                    resStep++;
                }
            } else if (sum == 1) {
                if (t == 0) {
                    resStep++;
                }
            } else if (sum == 2) {
                if (t == 0) {
                    resStep += 2;
                }
            }
            x = x >> 1;
            y = y >> 1;
            z = z >> 1;
        }
        return resStep;
    }

    public Main input(Scanner scan) {
        int[] in = Arrays.stream(scan.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        a = in[0];
        b = in[1];
        c = in[2];
        return this;
    }

    public static void main(String[] args) {
        int res = new Main().input(new Scanner(System.in)).compute();
        System.out.println(res);
    }
}

