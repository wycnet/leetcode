package easy.t7_11;


import java.util.Arrays;
import java.util.Scanner;

/**
 * 买票需要的时间
 */
public class Main {
    int[] tickets;
    int k;

    public void compute() {
        int time = 0;
        int i = 0;
        while (true) {
            if (tickets[k] == 0) {
                System.out.println(time);
                return;
            }
            if (tickets[i] != 0) {
                time++;
                tickets[i]--;
            }
            i = (i+1) % tickets.length;
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        Scanner scan = new Scanner(System.in);
        main.tickets = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        main.k = scan.nextInt();
        main.compute();
    }
}

