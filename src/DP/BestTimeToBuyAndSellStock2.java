package DP;

import java.util.Arrays;

public class BestTimeToBuyAndSellStock2 {

  static int solve(int index, int buy, int[] prices){
    if(index == prices.length){
      return 0;
    }

    if(buy == 1){
      return Math.max(-prices[index] + solve(index + 1, 0 , prices),  solve(index + 1, 1 , prices));
    }else{
      return Math.max(prices[index] + solve(index + 1, 1, prices), solve(index + 1, 0, prices));
    }
  }

  static int solve(int[] prices){
    int n = prices.length;
    int[][] dp = new int[n + 1][2];

    for(int i = n-1; i>= 0; i--){
      for( int buy = 0; buy <2 ; buy++){
        if(buy==1){
          dp[i][buy] = Math.max(-prices[i] + dp[i + 1][0], dp[i + 1][1]);
        }else{
          dp[i][buy] = Math.max(prices[i] + dp[i + 1][1], dp[i + 1][0]);
        }
      }
    }

    return dp[0][1];
  }
  static int maxProfit(int[] prices){
//    return solve(0, 1,prices);
    return solve(prices);
  }

  public static void main(String[] args) {
    int[] prices = {7,1,5,3,6,4} ; //{1, 2, 3, 3, 2, 1, 5};
    System.out.println(maxProfit(prices));
  }

}
