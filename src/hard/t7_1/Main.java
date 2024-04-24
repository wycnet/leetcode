package hard.t7_1;

import java.util.*;

/**
 * 按格式合并两个链表
 */
public class Main {

    Node listRoot1;
    Node listRoot2;
    int maxLine = 1;
    boolean debug = false;

    public void solve() {
        Node l1 = listRoot1;
        Node l2 = listRoot2;
        if (maxLine == 2) {
            l1 = listRoot2;
            l2 = listRoot1;
        }
        // 将链表2入栈
        Stack<Node> stack = new Stack<>();
        Node p = l2;
        while (p != null) {
            stack.push(p);
            p = p.next;
        }
        // 循环链表1，插入
        p = l1;
        int ind = 1;
        while (p != null && !stack.isEmpty()) {
            if (ind == 2) {
                ind = 1;
                Node t = stack.pop();
                t.next = p.next;
                p.next = t;
                p = t.next;
            } else {
                p = p.next;
                ind++;
            }
        }

        // 输出
        p = l1;
        while (p != null) {
            System.out.print(p.id+" "+p.value+" ");
            if (p.next == null) {
                System.out.println("-1");
            } else {
                System.out.println(p.next.id);
            }
            p = p.next;
        }
    }

    public Main input(Scanner scan) {
        String l1RootId = scan.next();
        String l2RootId = scan.next();
        int count = scan.nextInt();
        Map<String, String> idMap = new HashMap<>();
        Map<String, Node> nodeMap = new HashMap<>();
        for (int i = 0; i < count; i++) {
            String id = scan.next();
            int value = scan.nextInt();
            String nextId = scan.next();
            idMap.put(id, nextId);
            nodeMap.put(id, new Node(id, value));
        }

        listRoot1 = nodeMap.get(l1RootId);
        listRoot2 = nodeMap.get(l2RootId);
        int maxLine1 = 1;
        int maxLine2 = 1;
        // 创建链表1
        String nextId = idMap.get(l1RootId);
        Node p = listRoot1;
        while(!nextId.equals("-1")) {
            Node nextNode = nodeMap.get(nextId);
            nextId = idMap.get(nextId);
            p.next = nextNode;
            p = nextNode;
            maxLine1++;
        }
        // 创建链表2
        nextId = idMap.get(l2RootId);
        p = listRoot2;
        while(!nextId.equals("-1")) {
            Node nextNode = nodeMap.get(nextId);
            nextId = idMap.get(nextId);
            p.next = nextNode;
            p = nextNode;
            maxLine2++;
        }
        if (maxLine1 > maxLine2) {
            maxLine = 1;
        } else {
            maxLine = 2;
        }
        if (debug) {
            p = listRoot1;
            while (p != null) {
                System.out.println(p.id+" "+p.value);
                p = p.next;
            }
            p = listRoot2;
            while (p != null) {
                System.out.println(p.id+" "+p.value);
                p = p.next;
            }
        }
        return this;
    }

    static class Node {
        String id;
        int value;
        Node next;
        public Node (String id, int value) {
            this.id = id;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        new Main().input(new Scanner(System.in)).solve();
    }
}