package easy.t7_14;

import java.util.Scanner;
import java.util.Stack;

/**
 * 最小栈
 */
public class Main {

    // 正常保存
    Stack<Integer> s1 = new Stack<>();
    // 保存最小值
    Stack<Integer> s2 = new Stack<>();

    public void push(int v) {
        s1.push(v);
        if (s2.empty() || s2.peek() >= v) {
            s2.push(v);
        }
    }

    public int pop() {
        int top = s1.pop();
        if (top == s2.peek()) {
            s2.pop();
        }
        return top();
    }

    public int top() {
        return s1.peek();
    }

    public int getMin() {
        return s2.peek();
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input1 = scan.nextLine().split(",");
        String[] input2 = scan.nextLine().split(",");

        Main stack = new Main();

        for (int i = 0; i < input1.length; i++) {
            String comd = input1[i];
            if (comd.equals("push")) {
                stack.push(Integer.parseInt(input2[i]));
                System.out.print("null");
            } else if (comd.equals("getMin")) {
                System.out.print(stack.getMin());
            } else if (comd.equals("pop")) {
                stack.pop();
                System.out.print("null");
            } else if (comd.equals("top")) {
                System.out.print(stack.top());
            }
            if (i < input1.length -1) {
                System.out.print(",");
            }
        }


    }

}
