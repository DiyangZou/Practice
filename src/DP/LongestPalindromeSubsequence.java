package DP;

public class LongestPalindromeSubsequence {
    public int longestPalindrome(String input) {
        // Write your solution here
        if(input == null) return 0;
        char[] in = input.toCharArray();

        int[][] dp = new int[in.length][in.length];

        for(int i = 0; i < in.length; i++) {
            dp[i][i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (in[i] == in[j]) {
                    dp[i][j] = 2 + dp[i - 1][j + 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j + 1]);
                }
            }
        }
        return dp[in.length-1][0];
    }

    public static void main(String[] args) {
        LongestPalindromeSubsequence s = new LongestPalindromeSubsequence();
        int result = s.longestPalindrome("aa");
        System.out.print(result);
    }
}
