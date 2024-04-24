package middle.t7_1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 连续的子数组和
 */
public class Main {

    int[] nums;
    int k;

    // 如果sum[p] - sum[q] == k*n, 那么 sum[p]%k == sum[q]%k
    public int compute() {
        Map<Integer, Integer> map = new HashMap<>();
        long sum = nums[0];
        map.put((int) (sum % k), 0);
        for (int i = 1; i < nums.length; i++) {
            sum = sum + nums[i];
            int temp = (int) (sum % k);
            if (map.containsKey(temp)) {
                int preInd = map.get(temp);
                if (i - preInd >= 1) {
                    return 1;
                }
            } else {
                map.put(temp, i);
            }
        }
        return 0;
    }

    public Main input(Scanner scan) {
        nums = Arrays.stream(scan.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        k = scan.nextInt();
        return this;
    }


    public static void main(String[] args) {
        int res = new Main().input(new Scanner(System.in)).compute();
        System.out.println(res);
    }
}
