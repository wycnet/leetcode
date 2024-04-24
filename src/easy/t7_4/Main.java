package easy.t7_4;

import java.util.Scanner;

/**
 * 跳跃
 * Drizzle 被困到一条充满数字的方块路中，假设这条路由一个非负的整数数组m组成，
 * Drizzle 最开始的位置在下标 start 处，当他位于下标i位置时可以向前或者向后跳跃m[i]步数，
 * 已知元素值为0处的位置是出口，且只能通过出口出去，不可能数组越界，也不能折返，如果跳跃的步数超出数组范围，
 * 则也定义为失败，请你通过编程计算出Drizzle能否逃出这里。
 */
public class Main {
    int[] roads;
    int count;
    int start;

    public Main input(Scanner scan) {
        count = scan.nextInt();
        roads = new int[count];
        for (int i = 0; i < roads.length; i++) {
            roads[i] = scan.nextInt();
        }
        start = scan.nextInt();
        return this;
    }

    public void compute() {
        if (dfs(start)) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }

    public boolean dfs(int ind) {
        if (ind < 0 || ind >= count) {
            return false;
        }
        if (roads[ind] == 0) {
            return true;
        }
        int current = roads[ind];
        roads[ind] = count + 1;
        return dfs(ind - current) || dfs(ind + current);
    }

    public static void main(String[] args) {
        new Main().input(new Scanner(System.in)).compute();
    }

}
