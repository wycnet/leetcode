package middle.t7_6;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 最小数
 */
public class Main {

    String[] inp;
    boolean isMinus = false;
    String minuxStart;

    public String compute() {
        Arrays.sort(inp, (o1, o2) -> compare(o1, o2));
        StringBuffer sb = new StringBuffer();
        if (!isMinus) {
            for (int i = 0; i < inp.length; i++) {
                sb.append(inp[i]);
            }
        } else {
            sb.append(minuxStart);
            for (int i = inp.length - 1; i > 0; i--) {
                sb.append(inp[i]);
            }
        }
        return sb.toString();
    }

    // 核心思想是比较字符串大小
    // 如果长度相等直接compareTo,
    // 不相等的话，先比较开头等长部分，如果相等则将长串剪切掉前部分后继续比较； 相等的话直接返回
    public int compare(String s1, String s2) {
        if (s1.length() == s2.length()) {
            return s1.compareTo(s2);
        } else if (s1.length() < s2.length()) {
            int com = s1.compareTo(s2.substring(0, s1.length()));
            if (com == 0) {
                return compare(s1, s2.substring(s1.length()));
            } else {
                return com;
            }
        } else {
            int com = s1.substring(0, s2.length()).compareTo(s2);
            if (com == 0) {
                return compare(s1.substring(s2.length()), s2);
            } else {
                return com;
            }
        }
    }

    public Main input(Scanner scan) {
        inp = scan.nextLine().split(" ");
        for (int i = 0; i < inp.length; i++) {
            if (inp[i].startsWith("-")) {
                isMinus = true;
                minuxStart = inp[i];
                inp[i] = "0";
                break;
            }
        }
        return this;
    }


    public static void main(String[] args) {
        String res = new Main().input(new Scanner(System.in)).compute();
        System.out.println(res);
    }
}
