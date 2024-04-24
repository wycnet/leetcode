package easy.t7_6;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 同构字符串
 */
public class Main {
    String s1, s2;

    boolean compute() {
        if (s1.length() != s2.length()) {
            return false;
        }

        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            int c1 = s1.charAt(i);
            int c2 = s2.charAt(i);
            if ((map1.get(c1) != null && map1.get(c1) != c2) ||
                    (map2.get(c2) != null && c1 != map2.get(c2))) {
                return false;
            }
            map1.put(c1, c2);
            map2.put(c2, c1);
        }
        return true;
    }

    public Main input(Scanner scan) {
        String[] inp = scan.nextLine().split(",");
        s1 = inp[0];
        s2 = inp[1];
        return this;
    }

    public static void main(String[] args) {
        Main main = new Main();
        Scanner scan = new Scanner(System.in);
        boolean res = main.input(scan).compute();
        if (res) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }
    }
}
