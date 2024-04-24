package easy.t7_8;

import java.util.Scanner;


/**
 * 最长的美好字符子串
 */
public class Main {
    String s;

    // 枚举解法
    void computeEnum() {

        int maxLen = 0;
        int ind = 0;

        for (int i = 0; i < s.length(); i++) {
            int lower = 0, upper = 0;
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(j) <= 'Z') {
                    upper |= 1 << (s.charAt(j) - 'A');
                } else {
                    lower |= 1 << (s.charAt(j) - 'a');
                }
                if (lower == upper && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    ind = i;
                }
            }
        }

        System.out.println(s.substring(ind, ind + maxLen));
    }

    public static void main(String[] args) {
        Main main = new Main();
        Scanner scan = new Scanner(System.in);
        main.s = scan.nextLine();
        main.computeEnum();
    }

}
