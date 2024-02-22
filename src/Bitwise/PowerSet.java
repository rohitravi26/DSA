package Bitwise;

public class PowerSet {
  // O(2raise to n * n)
  static <T> void findAllCombinations(char[] s){
    int n = s.length;
    int setSize = 1 << n;

    for(int i = 0; i < setSize; i++){
      for(int j = 0; j < n; j++){
        if((i & (1 << j)) != 0){
          System.out.print(s[j]);
        }
      }
      System.out.println();
    }
  }
  public static void main(String[] args) {
    String s = "abc";
    findAllCombinations(s.toCharArray());
  }
}
