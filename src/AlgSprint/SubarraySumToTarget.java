package AlgSprint;

import java.util.Set;
import java.util.HashSet;

public class SubarraySumToTarget {

    public boolean sumToTarget(int[] nums, int k) {
        // Write your solution here
        // The given array is not null and its length is > 0.
        int sum = 0;
        Set<Integer> preSum = new HashSet<>();
        preSum.add(0);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (preSum.contains(sum - k)) {
                return true;
            }
            preSum.add(sum);
        }
        return false;
    }

    public static void main(String[] args) {
        SubarraySumToTarget s = new SubarraySumToTarget();
        boolean result = s.sumToTarget(new int[]{1,2,-5,3,-2,4}, -4);
        System.out.println(result);
    }
}
