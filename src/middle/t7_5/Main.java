package middle.t7_5;

import java.util.*;


/**
 * 三数之和
 */
class Main {
    int[] nums;

    private boolean debug = false;

    /**
     三指针法
     **/
    public void compute() {
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length-2; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int j = i+1, k = nums.length-1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    res++;
                    while(nums[j] == nums[j+1]) j++;
                    while(nums[k] == nums[k-1]) k--;
                    j++;
                    k--;
                } else if(sum < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        System.out.println(res);
    }

    public Main input(Scanner scan) {
        nums = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        if(debug) {
            System.out.println(Arrays.toString(nums));
        }
        return this;
    }

    public static void main(String[] args) {
        new Main().input(new Scanner(System.in)).compute();
    }
}