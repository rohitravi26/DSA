package Bitwise;

public class EvenOdd {
  static void isEven(int n){
    if((n & 1) == 1){
      System.out.println("odd");
    }else {
      System.out.println("even");
    }
  }
  public static void main(String[] args) {
    isEven(21);
  }
}
