package easy.t7_17;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 交换和
 */
public class Main {
    ArrayList<Long> la = new ArrayList<>();
    ArrayList<Long> lb = new ArrayList<>();

    public void compute() {
        long sum1 = 0, sum2 = 0;
        sum1 = la.stream().mapToInt(Long::intValue).sum();
        sum2 = lb.stream().mapToInt(Long::intValue).sum();

        // 差值是奇数，表明没有满足条件的
        if (((sum2 - sum1) % 2) != 0) {
            System.out.println("");
            return;
        }

        long target = (sum2 - sum1) / 2;
        // 将第二个数组放入set
        Set<Long> set = new HashSet<Long>(lb);

        // 记录已经访问过
        Set<Long> setA = new HashSet<>();

        // 扫描一遍第一个数组
        for (long i : la) {
            if (setA.contains(i)) {
                continue;
            }
            setA.add(i);
            if (set.contains(target + i)) {
                System.out.println(i + " " + (target + i));
            }
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Main main = new Main();
        main.la = Arrays.stream(scan.nextLine().split(" "))
                .map(Long::parseLong)
                .collect(Collectors.toCollection(ArrayList::new));
        main.lb = Arrays.stream(scan.nextLine().split(" "))
                .map(Long::parseLong)
                .collect(Collectors.toCollection(ArrayList::new));
        main.compute();
    }
}
