package Bitwise;

public class FindOneOddOccurring {
  public static int find(int[] arr){
    int res = 0;
    for (int j : arr) {
      res = res ^ j;
    }
    System.out.println(res);
    return res;
  }

  public static void main(String[] args) {
    find(new int[]{1,1,2,3,3});
  }
}
