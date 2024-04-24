package hard.t7_3;

/**
 * 同类型题目集合：https://leetcode.cn/problems/create-maximum-number/solutions/297892/yi-zhao-chi-bian-li-kou-si-dao-ti-ma-ma-zai-ye-b-7/
 */

import java.util.*;

/**
 * 拼接最大数
 */
class Main {
    String s1;
    String s2;
    int k;
    private boolean debug = false;

    public void solve() {
        String res = "";
        for (int i = 0; i <= k; i++) {
            int j = k - i;
            if (i > s1.length() || j > s2.length()) {
                continue;
            }
            String sub1 = maxSub(s1, i);
            String sub2 = maxSub(s2, j);
            String mixStr = mixStr(sub1, sub2);
            if (res.compareTo(mixStr) < 0) {
                res = mixStr;
            }
        }
        for(int i=0; i < res.length(); i++) {
            System.out.print(res.charAt(i));
            if (i == res.length() - 1) {
                System.out.println();
            } else {
                System.out.print(",");
            }
        }
    }

    // 单调栈
    public String maxSub(String s, int c) {
        char[] stack = new char[s.length()];
        int ind = -1;
        int count = s.length() - c; // 要删掉的数量
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            while (ind >= 0 && ch > stack[ind] && count > 0) {
                ind--; // 将栈顶弹出
                count--; // 记录删掉数量
            }
            stack[++ind] = ch;
        }
        return new String(Arrays.copyOfRange(stack, 0, c));
    }

    public String mixStr(String st1, String st2) {
        StringBuilder sb = new StringBuilder();
        int ind1 = 0, ind2 = 0;
        while (ind1 < st1.length() && ind2 < st2.length()) {
            char c1 = st1.charAt(ind1);
            char c2 = st2.charAt(ind2);
            if (c1 > c2) {
                sb.append(c1);
                ind1++;
            } else if (c1 < c2) {
                sb.append(c2);
                ind2++;
            } else {
                sb.append(c1);
                sb.append(c2);
                ind1++;
                ind2++;
            }
        }
        if (ind1 < st1.length()) {
            sb.append(st1.substring(ind1));
        }
        if (ind2 < st2.length()) {
            sb.append(st2.substring(ind2));
        }
        return sb.toString();
    }

    public Main input(Scanner scan) {
        s1 = scan.nextLine().replace(",", "");
        s2 = scan.nextLine().replace(",", "");
        k = scan.nextInt();
        if (debug) {
            System.out.println(s1+"\n"+s2+"\n"+k);
        }

        return this;
    }
    public static void main(String[] args) {
        new Main().input(new Scanner(System.in)).solve();
    }
}