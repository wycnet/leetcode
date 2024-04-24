package hard.t7_12;

import java.util.*;

/**
 * 超级回文数
 */
class Main {

    long L, R;

    public Main input(Scanner scan) {
        String[] inp = scan.nextLine().split(",");
        L = Long.valueOf(inp[0]);
        R = Long.valueOf(inp[1]);
        return this;
    }

    public void solve() {
        Set<Long> al = new TreeSet<Long>();
        for (long i = 1L; i <= 99999; i++) {
            String v = String.valueOf(i);
            String vv = createReverse(v, 1);
            long lvv =  Long.valueOf(vv);
            long lvv2 = lvv * lvv;
            String vv2 = String.valueOf(lvv2);
            if (lvv2 >= L && lvv2 <= R && isHw(vv2)) {
                al.add(lvv2);
            }

            vv = createReverse(v, 2);
            lvv = Long.valueOf(vv);
            lvv2 = lvv * lvv;
            vv2 = String.valueOf(lvv2);
            if (lvv2 >= L && lvv2 <= R && isHw(vv2)) {
                al.add(lvv2);
            }
        }
        System.out.println(al.toString());
    }

    public String createReverse(String str, int type) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        if (type == 1) {
            sb.append(new StringBuilder(str).reverse());
        } else if(str.length() > 1){
            sb.append(new StringBuilder(str.substring(0, str.length()-1)).reverse());
        }
        return sb.toString();
    }

    public boolean isHw(String s) {
        int start = 0, end = s.length() - 1;
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        new Main().input(new Scanner(System.in)).solve();
    }
}
