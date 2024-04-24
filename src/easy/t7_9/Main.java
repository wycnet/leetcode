package easy.t7_9;

import java.util.Scanner;

/**
 * 最小硬币个数
 */
public class Main {

    long n;
    long[] coin = {1, 2, 5};

    void compute() {
        long count = 0;
        long total = n;
        for (int i = 2; i >= 0; i--) {
            count += total / coin[i];
            total = total % coin[i];
            if (total == 0) {
                break;
            }
        }
        if (count == 0) {
            count = -1;
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        Main main  = new Main();
        Scanner scan = new Scanner(System.in);
        main.n = scan.nextLong();
        main.compute();
    }
}
