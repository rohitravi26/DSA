package interview;

public class CARS24 {

  public static void main(String[] args) {
    int n = 65;
    n |= n >>> 1;
    n |= n >>> 2;
    n |= n >>> 4;
    n |= n >>> 8;
    n |= n >>> 16;

    System.out.println(n);
  }
}
