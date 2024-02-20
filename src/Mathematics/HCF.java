package Mathematics;
/*
HCF or GCD(greatest common divisor
Approach 1:
g = gcd(a,b);
a = gx, b = gy
a-b = g(x-y), gcd(x,y) = 1
gcd(a-b, b) = gcd(a, b);

Approach 2:
 gcd(a,b) = b==0 ? a : gcd(b, a%b);
 */
public class HCF {
  static int hcf(int a, int b){
    while(a != b){
      if(a > b){
        a -= b;
      }else {
        b -= a;
      }
    }
    return a;
  }
  // tc : log(min(a,b))
  static int hcfOptimized(int a, int b){
    if(b == 0){
      return a;
    }

    return hcfOptimized(b, a%b);
  }
  public static void main(String[] args) {
    System.out.println(hcf(19,38));
  }
}
