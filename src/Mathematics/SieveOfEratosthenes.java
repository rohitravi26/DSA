package Mathematics;

import java.util.Arrays;

public class SieveOfEratosthenes {
  // tc: O(nlog(logn))
  static void findAllPrimeNumber(int n){
    boolean[] isPrime = new boolean[n+1];
    Arrays.fill(isPrime, true);

    for(int i=2; i<=n; i++){
      if(isPrime[i]){
        System.out.print(i + " ");
      }
      for(int j=i*i; j<=n; j+=i){
        isPrime[j] = false;
      }
    }
    /*
    for(int i = 2; i * i <= n; i++){
      if(isPrime[i]){
        for (int j = i*i; j <= n; j+=i)
          isPrime[j] = false;
      }
    }

    for(int i = 2; i<=n; i++){
      if (isPrime[i]) {
        System.out.print( i + " ");
      }
    }
    */
  }
  public static void main(String[] args) {
    findAllPrimeNumber(23);
  }
}
