package DP;

public class LongestPalindromicSubstring {
    // dp
    static void printLongestPalindrome(String s){
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        // palindrome of length 1
        for(int i=0; i<n; i++){
            dp[i][i] = true;
        }
        int start = 0;
        int maxLength = 0;
        // palindrome of length 2
        for (int i=0; i<n-1; i++){
            if(s.charAt(i) == s.charAt(i+1)) {
                dp[i][i + 1] = true;
                start = i;
                maxLength = 2;
            }
        }

        // palindrome of length > 2
        for(int k = 3; k<=n ; k++){
            for(int i = 0; i < n-k+1; i++){
                int j = i+k-1;
                if(dp[i +1][j -1] && s.charAt(i) == s.charAt(j)){
                    dp[i][j] = true;
                    if(maxLength < k){
                        start = i;
                        maxLength = k;
                    }
                }

            }
        }

        System.out.println(s.substring(start,maxLength+start));
    }

    public static void main(String[] args) {
        printLongestPalindrome("geekssked");
    }
}
