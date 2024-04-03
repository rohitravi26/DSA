package String;

import DP.LongestCommonSubsequence;

public class OneEditDistance {

  public static void main(String[] args) {
    String a = "abcde";
    String b = "abcde";

    System.out.println(isOneEditDistance(a, b));

    // dp
    System.out.println(Math.abs(LongestCommonSubsequence.findLongestCommonSubsequence(a,b) - a.length()) == 1);
  }

  private static boolean isOneEditDistance(String a, String b) {
    int m = a.length();
    int n =  b.length();
    if(m > n) isOneEditDistance(b, a);

    int shift = n - m;

    if(shift > 1) return false;

    int i = 0;

    while(i < m && a.charAt(i) == b.charAt(i)) i++;

    if(i == m) return shift > 0;

    if(shift == 0) i++;

    while(i < m && a.charAt(i) == b.charAt(i + shift)) i++;

    return i == m;
  }
}
