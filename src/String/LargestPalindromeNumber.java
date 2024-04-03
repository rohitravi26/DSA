package String;

import java.util.HashMap;
import java.util.Map;

public class LargestPalindromeNumber {
  public static String largestPalindromic(String num) {

    int[] hash = new int[10];
    char[] chars = num.toCharArray();
    int n = chars.length;
    for( char c : chars ){
      hash[c - '0']++;
    }
    if(hash[0] == n){
      return "0";
    }
    StringBuilder first = new StringBuilder();
    StringBuilder last = new StringBuilder();
    char middle = 'a';
    boolean middleFlag = true;
    for(int i = 9; i >= 0 ; i--){
      if(middleFlag && hash[i] % 2 != 0){
        middleFlag = false;
        middle = (char) (i + '0');
      }
      if(i == 0 && first.length() == 0)
        break;
      int freq = hash[i]/2;
      while(freq > 0){
        first.append(i);
        last.insert(0, i);
        freq--;
      }
    }
    if(!middleFlag)
      first.append(middle);
    first.append(last);

    return first.toString();
  }

  public static void main(String[] args) {
    System.out.println(largestPalindromic("444947137"));
  }
}
