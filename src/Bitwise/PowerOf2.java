package Bitwise;

public class PowerOf2 {

  static void isPower2(int n){
    System.out.println((n & (n & n-1)) == 0); // first conition is to check for n == 0
  }

  public static void main(String[] args) {
    isPower2(40);
  }

}
