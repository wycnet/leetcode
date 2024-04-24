package easy.t7_10;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 判断二叉树是不是搜索树
 */
class Main {

    class Node {
        Long value;
        Node left;
        Node right;
    }

    boolean res = true;
    Node root;

    public void solve() {
        dfs(root);
        if (res) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

    public Long dfs(Node n) {
        if (n == null) {
            return null;
        }
        // System.out.print(n.value + " ");
        Long left = null;
        Long right = null;

        left = dfs(n.left);
        right = dfs(n.right);
        if (left != null && left >= n.value) {
            res = false;
            return null;
        }
        if (right != null && right <= n.value) {
            res = false;
            return null;
        }
        if (right != null) {
            return right;
        } else {
            return n.value;
        }

    }

    public Main input(Scanner scan) {
        String[] inp = scan.nextLine().split(",");
        Deque<Node> deq = new LinkedList<Node>();
        root = new Node();
        root.value = Long.valueOf(inp[0]);
        deq.addLast(root);
        int ind = 1;
        while (deq.size() != 0) {
            Node t = deq.pollFirst();
            String lv = "null";
            if (ind < inp.length)
                lv = inp[ind++];
            String rv = "null";
            if (ind < inp.length)
                rv = inp[ind++];
            if (!lv.equals("null")) {
                Node l = new Node();
                l.value = Long.valueOf(lv);
                t.left = l;
                deq.addLast(l);
            }
            if (!rv.equals("null")) {
                Node r = new Node();
                r.value = Long.valueOf(rv);
                t.right = r;
                deq.addLast(r);
            }
        }

        return this;
    }


    public static void main(String[] args) {
        new Main().input(new Scanner(System.in)).solve();
    }
}
