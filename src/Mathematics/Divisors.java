package Mathematics;

public class Divisors {
  static void findDivisors(int n){
    int i = 1;
    for(; i*i <= n; i++){
      if(n % i == 0){
        System.out.println(i);
      }
    }
    for(; i >= 2; i--){
      if(n % i == 0){
        System.out.println(n/i);
      }
    }
  }
  public static void main(String[] args) {
    findDivisors(48);
  }
}
