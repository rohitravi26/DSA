package Bitwise;

public class CountSetBits {

  // using look up table tc : O(1)
  static int countSetBits(int n){
    int[] setBitsCount = new int[256];
    setBitsCount[0] = 0;
    for(int i = 1; i < 256; i++){
      setBitsCount[i] = setBitsCount[i & (i-1)] + 1;
    }
    // here 255 has all last 8 bits set to 1 ( which will give the number as we are doing and operation with 1),
    // that's why we divided into 4 groups each of 8bits to complete 32 bits.
    return setBitsCount[n & 255] + setBitsCount[(n >> 8) & 255] + setBitsCount[(n >> 16) & 255] + setBitsCount[n >> 24];
  }

  // Brian kerningam algo tc : O(no of set bits)
  static int count(int n){
    int res = 0;
    while(n > 0){
      // 8 = 1000, 7 = 0111 => n = 0000, count = 1
      n = n & (n-1);
      res++;
    }
    return res;
  }

  // naive approach tc: O(no of bits)
  static void countBits(int n){
    int res = 0;
    while(n > 0){
      res = res + (n & 1);
      n = n/2;
    }
    System.out.println(res);
  }

  public static void main(String[] args) {
    countBits(40);
    System.out.println(count(40));
    System.out.println(countSetBits(40));
  }
}
