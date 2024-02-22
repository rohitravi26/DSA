package Bitwise;

public class CheckKthBitSet {

  static void checkForKthBit(int n, int k){
    // find 2 to th power k-1;
    int x = 1 << (k-1);

    System.out.println((n & x) != 0);
  }

  public static void main(String[] args) {
    /*
      n = 7 => 111
      k = 1
      x = 001

      k = 2
      x = 010
      111 & 010 = 010 => 2

     */
    checkForKthBit(7, 1);
  }

}
