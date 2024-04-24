package easy.t7_12;

import java.util.*;

/**
 * 无法吃午餐的学生数量
 */
public class Main {
    Deque<Integer> student = new LinkedList<>();
    Deque<Integer> sandwiches = new LinkedList<>();

    public void compute() {

        while (!sandwiches.isEmpty()) {
            int sand = sandwiches.pollFirst();
            int roundCount = student.size();
            while (true) {
                if (student.getFirst() != sand) {
                    student.addLast(student.getFirst());
                    student.removeFirst();
                    roundCount--;
                } else {
                    student.removeFirst();
                    break;
                }
                if (roundCount < 0) {
                    System.out.println(student.size());
                    return;
                }
            }
        }
        System.out.println(0);
    }

    public static void main(String[] args) {
        Main main = new Main();
        Scanner scan = new Scanner(System.in);
        Arrays.stream(scan.nextLine().split(" ")).forEach(s ->
                main.student.addLast(Integer.valueOf(s))
        );
        Arrays.stream(scan.nextLine().split(" ")).forEach(s ->
                main.sandwiches.add(Integer.valueOf(s))
        );
        main.compute();
    }

}
