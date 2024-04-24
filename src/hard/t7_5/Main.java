package hard.t7_5;


import java.util.*;

/**
 * 二叉树的最大路径和
 */
class Main {
    Node root;
    private boolean debug = false;
    int maxRes = -10000;

    public void solve() {
        if (root == null) {
            System.out.println("0");
            return;
        }
        int maxLen = dfs(root);
        System.out.print(maxRes);
    }

    private int dfs(Node root) {
        if (root == null) {
            return 0;
        }
        if (debug) {
            System.out.println(root.value);
        }
        int left = Math.max(0, dfs(root.left));
        int right = Math.max(0, dfs(root.right));
        maxRes = Math.max(maxRes, left+right+root.value);
        return Math.max(left, right) + root.value;

    }

    public Main input(Scanner scan) {
        Queue<Node> que = new LinkedList<>();
        String[] inp = scan.nextLine().split(",");
        if (debug) {
            System.out.println(Arrays.toString(inp));
        }
        int ind = 0;
        root = new Node();
        if (inp[ind].equals("null")) {
            return this;
        }
        root.value = Integer.parseInt(inp[ind++]);
        que.offer(root);
        while (ind < inp.length && que.size()!= 0) {
            Node left = new Node();
            Node right = new Node();
            Node root = que.poll();
            String sl = ind < inp.length? inp[ind++] : "null";
            String sr = ind < inp.length? inp[ind++] : "null";
            if (!sl.equals("null")) {
                left.value = Integer.parseInt(sl);
                root.left = left;
                que.offer(left);
            }
            if (!sr.equals("null")) {
                right.value = Integer.parseInt(sr);
                root.right = right;
                que.offer(right);
            }
        }
        return this;
    }

    public static class Node {
        int value;
        Node left;
        Node right;
    }
    public static void main(String[] args) {
        new Main().input(new Scanner(System.in)).solve();
    }
}
