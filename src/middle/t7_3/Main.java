package middle.t7_3;

import java.util.Scanner;
import java.util.Stack;


/**
 * 删除无效的括号
 */
public class Main {

    String s;

    public String compute() {
        Stack<Data> s1 = new Stack<>();
        boolean[] arr = new boolean[s.length()];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')') {
                if (!s1.empty() && s1.peek().c == '(') {
                    s1.pop();
                } else {
                    arr[i] = true;
                }
            } else if (c == '(') {
                s1.add(new Data(i, c));
            }
        }

        while (!s1.isEmpty()) {
            arr[s1.pop().ind] = true;
        }

        StringBuffer res = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            if (!arr[i]) {
                res.append(s.charAt(i));
            }
        }
        return res.toString();
    }

    public Main input(Scanner scan) {
        s = scan.nextLine();
        return this;
    }

    static class Data {
        int ind;
        char c;

        public Data(int ind, char c) {
            this.ind = ind;
            this.c = c;
        }
    }


    public static void main(String[] args) {
        String res = new Main().input(new Scanner(System.in)).compute();
        System.out.println(res);
    }
}
