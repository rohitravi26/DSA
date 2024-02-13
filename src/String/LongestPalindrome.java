package String;

public class LongestPalindrome {

    public static void main(String[] args) {

        String str="aaaabbaa";

        String res=longestPalindrome(str);
        System.out.println(res);

    }

    private static String longestPalindrome(String str) {

        int n=str.length();
        int maxlength=1;
        int start=0;
        boolean dp[][] = new boolean[n][n];

        for(int i=0;i<n;i++)
            dp[i][i]=true;

        for(int i=0;i<n-1;i++)
        {
            if(str.charAt(i)==str.charAt(i+1))
            {

                if(maxlength < 2)
                {
                    maxlength=2;
                    start=i;}
                    dp[i][i+1]=true;
            }
        }

        for (int len=3;len<=n;len++)
        {
            for (int i=0;i<n-len+1;i++)
            {
                int j=i+len-1;
                if(str.charAt(i)==str.charAt(j) && dp[i+1][j-1])
                {
                    dp[i][j]=true;

                   // if(maxlength < j-i+1) {
                    if(maxlength < len) {
                        maxlength = j - i + 1;
                        start = i;
                    }
                }


            }
        }

    return str.substring(start,start+maxlength);
    }
}
