package easy.t7_7;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 数字拆分求和
 */
public class Main {

    int sum = 0;

    private void compute() {
        for (int i = 1; i < sum - 1; i++) {
            int ind  = canSum(i);
            if (ind < 0) {
                continue;
            }
            ArrayList<String> arr = new ArrayList<>();
            int startX = i;
            for (int j = 0; j<= ind; j++) {
                startX += j;
                arr.add(String.valueOf(startX));
            }
            System.out.println(String.join(",", arr));
        }
    }

    private int canSum(int x) {
        int ind = 1;
        int res = x;
        int temp = x;
        while (res < sum) {
            temp += ind;
            res += temp;
            if (res == sum) {
                return ind;
            }
            ind++;
        }
        return -1;
    }

    public void start(String input) {
        sum = Integer.parseInt(input);
        compute();
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        new Main().start(scan.nextLine());
    }
}
