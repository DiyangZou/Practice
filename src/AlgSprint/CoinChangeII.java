package AlgSprint;

public class CoinChangeII {

//    public int coinChange(int amount, int[] coins) {
//        // Write your solution here
//        int[] result = new int[]{0};
//        helper(amount, coins, result, 0);
//        return result[0];
//    }
//
//    private void helper(int amount, int[] coins, int[] result, int index){
//        if(index == coins.length){
//            return;
//        }
//        if(amount == 0){
//            result[0]++;
//            return;
//        }
//        int maxCount = amount / coins[index];
//        for(int i = maxCount; i >= 0; i--){
//            int remain = amount - i * coins[index];
//            helper(remain, coins, result, index+1);
//        }
//    }

    public int coinChange(int amount, int[] coins) {
        // Write your solution here
        int[][] dp = new int[coins.length+1][amount+1];
        dp[0][0] = 1;
        for (int i = 1; i <= coins.length; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= amount; j++) {
                dp[i][j] = dp[i-1][j] + (j >= coins[i-1] ? dp[i][j-coins[i-1]] : 0);
            }
        }
        return dp[coins.length][amount];
    }


    public static void main(String[] args) {
        CoinChangeII s = new CoinChangeII();
        int result = s.coinChange(5, new int[]{1,2});
        System.out.print(result);
    }
}
