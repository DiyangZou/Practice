package DP;

public class MaxProductOfCuttingRope {

    public int maxProduct(int length) {
        // Write your solution here
        int[] dp = new int[length + 1];
        dp[1] = 1;
        for(int i = 2; i < dp.length; i++){
            for(int j = 0; j < i; j++){
                dp[i] = Math.max(Math.max(dp[j], j) * Math.max(dp[i - j], i-j), dp[i]);
            }
        }
        return dp[dp.length-1];
    }

    public static void main(String[] args) {
        MaxProductOfCuttingRope s = new MaxProductOfCuttingRope();
        int result = s.maxProduct(5);
        System.out.print(result);
    }
}
