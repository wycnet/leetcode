package middle.t7_8;

import java.util.*;

/**
 * 使用作弊方法
 */
public class Main2 {
    List<Node> list = new ArrayList<>();
    int N, K;

    public void solve() {
        List<Node> res = new ArrayList<>();
        for (int i = 0; i < N; i = i + K) {
            int end = i + K;
            if (end <= N) {
                List<Node> subList = list.subList(i, end);
                Collections.reverse(subList);
                res.addAll(subList);
            } else {
                List<Node> subList = list.subList(i, N);
                res.addAll(subList);
            }

        }

        for (int j = 0; j < N; j++) {
            System.out.print(res.get(j).id + " " + res.get(j).value + " ");
            if (j < N - 1) {
                System.out.println(res.get(j + 1).id);
            } else {
                System.out.println(-1);
            }
        }

    }

    public Main2 input(Scanner scan) {
        String rootId = scan.next();
        N = scan.nextInt();
        K = scan.nextInt();

        Map<String, String> idMap = new HashMap();
        Map<String, Node> nodeMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String id = scan.next();
            int value = scan.nextInt();
            String nextId = scan.next();
            idMap.put(id, nextId);
            Node n = new Node();
            n.value = value;
            n.id = id;
            nodeMap.put(id, n);
        }

        String cid = rootId;
        while (cid != null) {
            list.add(nodeMap.get(cid));
            cid = idMap.get(cid);
        }
        return this;
    }

    class Node {
        int value;
        String id;
    }

    public static void main(String[] args) {
        new Main2().input(new Scanner(System.in)).solve();
    }
}
