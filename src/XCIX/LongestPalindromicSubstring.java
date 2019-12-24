package XCIX;

public class LongestPalindromicSubstring {

    public String longestPalindrome(String input) {
        // Write your solution here
        if(input == null || input.length() == 0){
            return input;
        }
        char[] in = input.toCharArray();
        Pair[] dp = new Pair[input.length()];
        dp[0] = new Pair(0, 0);
        for(int i = 1; i < dp.length; i++){
            dp[i] = dp[i-1];
            for(int j = 0; j < i; j++){
                if(isPalindromic(in, j, i)){
                    Pair cur = new Pair(j, i);
                    dp[i] = dp[i].right - dp[i].left > i - j ? dp[i]:cur;
                }
            }
        }
        return new String(in, dp[dp.length-1].left, dp[dp.length-1].right-dp[dp.length-1].left+1);
    }

    private boolean isPalindromic(char[] in, int x, int y){
        while(x <= y){
            if(in[x++] != in[y--]){
                return false;
            }
        }
        return true;
    }
    class Pair{
        int left;
        int right;

        public Pair(int left, int right){
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring s = new LongestPalindromicSubstring();
        String result = s.longestPalindrome("abacbbcabcb");
        System.out.print(result);
    }
}
