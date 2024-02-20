package Mathematics;

public class FindPower {
  // tc: o(logn) space: o(logn)
  static int findPowerRecursive(int x, int n){
    if(n == 0)
      return 1;
    int temp = findPowerRecursive(x,n/2);
    temp *= temp;
    if(n % 2 == 0){
      return temp;
    }
    return temp * x;
  }

  // tc : o(logn) space : o(1)
  static int power(int x, int y){
    int res = 1;
    /* 3 to 10 => 10: 1010
    step 1 : 1010 & 0001 == 0 i.e even no
        res = 1
        x = 3 * 3
        y = 101
    step 2 : 101 & 001 == 1 i.e odd number
        res = 1 * (3 * 3)
        x = (3 * 3) * (3 * 3)
        y = 10
    step 3 : 10 & 01 == 0 i.e even
        x = (3 * 3 * 3 * 3) * (3 * 3 * 3 * 3)
        y = 1
    step 4 : 1 & 1 == 1 i.e odd
        res = (3 * 3) * (3 * 3 * 3 * 3 * 3 * 3 * 3 * 3)
        x = (3 * 3 * 3 * 3 * 3 * 3 * 3 * 3) * (3 * 3 * 3 * 3 * 3 * 3 * 3 * 3)
        y = 0
     */
    while(y > 0){
      if((y&1) == 1){ // odd scenario
        res *= x;
      }

      x = x * x;
      y = y >> 1;
    }
    return res;
  }

  public static void main(String[] args) {
    System.out.println(findPowerRecursive(2,5));
    System.out.println(power(2,5));
  }
}
