package easy.t7_1;

import java.util.*;


/**
 * 用栈实现队列
 */
class Main {

    // 保存正常顺序
    Stack<Integer> stack1 = new Stack<Integer>();
    // 保存倒序
    Stack<Integer> stack2 = new Stack<Integer>();
    boolean inStack1 = true;

    public void push(int x) {
        if (inStack1) {
            stack1.push(x);
        } else {
            while(stack2.size() > 0) {
                stack1.push(stack2.pop());
            }
            stack1.push(x);
        }
        inStack1 = true;
    }

    public int pop() {
        if (inStack1) {
            while(stack1.size() > 0) {
                stack2.push(stack1.pop());
            }
        }
        inStack1 = false;
        return stack2.pop();
    }

    public int peek() {
        if (inStack1) {
            while(stack1.size() > 0) {
                stack2.push(stack1.pop());
            }
        }
        inStack1 = false;
        return stack2.peek();
    }

    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public static void main(String[] args) {
        Main myQueue = new Main();
        Scanner scan = new Scanner(System.in);
        String[] argOperates = scan.nextLine().split(",");
        String[] argNum = scan.nextLine().split(",");
        for(int i = 0; i< argOperates.length; i++) {
            String operate = argOperates[i];
            if (operate.equals("push")) {
                myQueue.push(Integer.parseInt(argNum[i]));
                System.out.print("null");
            } else if (operate.equals("pop")) {
                System.out.print(myQueue.pop());
            } else if (operate.equals("peek")) {
                System.out.print(myQueue.peek());
            } else if (operate.equals("empty")) {
                System.out.print(myQueue.empty());
            }
            if (i < argOperates.length - 1) {
                System.out.print(",");
            }
        }
    }
}

