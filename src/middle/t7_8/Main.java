package middle.t7_8;

import java.util.*;

/**
 * 分段反转链表
 */
public class Main {
    private Node root;
    int N, K;
    private boolean debug = false;

    public void solve() {
        // 分段反转
        Node p = root;
        Node head = root;
        Node newRoot = new Node();
        newRoot.next = root;
        root.pre = newRoot;
        int ind = K;
        while (p != null) {
            ind--;
            if (ind == 0) {
                reverse(head, p);
                head = head.next;
                p = head;
                ind = K;
            } else {
                p = p.next;
            }
        }

        Node ptr = newRoot.next;
        while(ptr != null) {
            System.out.print(String.format("%05d", ptr.id)
                    + " " + ptr.value);
            if (ptr.next == null) {
                System.out.println(" " + "-1");
            } else {
                System.out.println(" " + String.format("%05d", ptr.next.id));
            }
            ptr = ptr.next;
        }
    }

    private void reverse(Node h, Node e) {
        Node p = h.next;
        Node x = h;
        Node head = h.pre;
        Node end = e.next;
        while (p != end) {
            Node t = p;
            p = p.next;
            h.pre = t;
            t.next = h;
            h = t;
        }
        if (head != null) {
            head.next = h;
            h.pre = head;
        } else {
            h.pre = null;
        }
        if (end != null) {
            x.next = end;
            end.pre = x;
        } else {
            x.next = null;
        }
    }

    public Main input(Scanner scan) {
        root = new Node();
        root.id = scan.nextInt();
        N = scan.nextInt();
        K = scan.nextInt();
        Map<Integer, Node> nodeMap = new HashMap<>();
        Map<Integer, Integer> idMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            Node node = new Node();
            node.id = scan.nextInt();
            node.value = scan.nextInt();
            idMap.put(node.id, scan.nextInt());
            nodeMap.put(node.id, node);
        }
        // 创建链表
        Node head = nodeMap.get(root.id);
        root = head;
        int nextId = idMap.get(head.id);
        while (nextId != -1) {
            Node nextNode = nodeMap.get(nextId);
            head.next = nextNode;
            nextNode.pre = head;
            nextId = idMap.get(nextNode.id);
            head = nextNode;
        }
        if (debug) {
            Node p = root;
            Node d = null;
            while(p != null) {
                System.out.print(p.value + " ");
                if (p.next == null) {
                    d = p;
                }
                p = p.next;
            }
            System.out.println();

            // 往前输出
            while (d != null) {
                System.out.print(d.value + " ");
                d = d.pre;
            }
        }
        return this;
    }

    public static class Node {
        int value;
        int id;
        Node pre;
        Node next;
    }

    public static void main(String[] args) {
        new Main().input(new Scanner(System.in)).solve();
    }
}