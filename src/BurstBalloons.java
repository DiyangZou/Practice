public class BurstBalloons {

    public int maxCoins(int[] iNums) {
        // Write your solution here
        int[] nums = new int[iNums.length + 2];
        int n = 1;
        for (int x : iNums) if (x > 0) nums[n++] = x;
        nums[0] = nums[n++] = 1;


        int[][] dp = new int[n][n];
        for (int k = 2; k < n; ++k)
            for (int left = 0; left < n - k; ++left) {
                int right = left + k;
                for (int i = left + 1; i < right; ++i)
                    dp[left][right] = Math.max(dp[left][right],
                            nums[left] * nums[i] * nums[right] + dp[left][i] + dp[i][right]);
            }

        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        BurstBalloons s = new BurstBalloons();
        int result = s.maxCoins(new int[]{3,1,5,8});
        System.out.print(result);
    }
}
