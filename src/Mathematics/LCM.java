package Mathematics;
/*
Least common multiple

 */
public class LCM {
  // O(log(min(a,b))
  static int lcm(int a, int b){
    return a*b / HCF.hcfOptimized(a, b);
  }
  public static void main(String[] args) {
    System.out.println(lcm(4, 6));
  }
}
