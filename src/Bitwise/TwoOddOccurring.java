package Bitwise;

public class TwoOddOccurring {

  static void findOdd(int[] arr){
    // res = 4 ^ 6 = 0100 ^ 0110 = 0010 = 2 1101 + 1 = 1110 & 0010
    int x = FindOneOddOccurring.find(arr);
    // It finds the number which has only 1 bit set and the  set bit corresponds to last  set bit of x.
    int k = x &(-x); // or int k = x &(~(x-1));
    int res1 = 0, res2 = 0;
    for (int i : arr){
      if((i & k) != 0){
        res1 = res1 ^ i;
      }else {
        res2 ^= i;
      }
    }
    System.out.println(res1 +" "+ res2);
  }
  public static void main(String[] args) {
    findOdd(new int[]{1,1,2,2,3,3,4,6});
  }
}
