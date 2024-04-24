package easy.t7_5;

import java.util.Scanner;

/**
 * 检测回文字符串
 */
public class Main {
    String inputString;

    boolean compute() {
        int start = 0, end = inputString.length() - 1;
        while (start < end) {
            if (inputString.charAt(start) != inputString.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    Main input(String input) {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if ((c >= 'a' && c <= 'z')
                    || (c >= 'A' && c <= 'Z')
                    || (c >= '0' && c <= '9')
            ) {
               buffer.append(c);
            }
        }
        inputString = buffer.toString();
        return this;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean res = new Main().input(scan.nextLine().toLowerCase()).compute();
        if (res) {
            System.out.print("1");
        } else {
            System.out.println("0");
        }

    }
}
