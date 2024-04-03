package Greedy;

/*
  You are given a record of the historical prices of an investment asset from the last N days.
  Analyze the record in order to calculate what could have been your maximum income.
  Assume you started with one asset of this type and could hold at most one at a time.
  You could choose to sell the asset whenever you held one.
  If you did not hold an asset at some moment, you could always afford to buy an asset (assume you had infinite money available).
 */
public class BestTimeToBuyAndSellStock2 {

  static int maxProfit(int[] prices){
    int profit = 0;
    int buy = 0;

    for(int i =0; i<prices.length; i++){
      if(buy < prices[i]){
        profit = profit + prices[i] - buy;
      }
      buy = prices[i];
    }
    return profit;
  }

  public static void main(String[] args) {
    int[] prices = {7,1,5,3,6,4} ;//{1, 2, 3, 3, 2, 1, 5};
    System.out.println(maxProfit(prices));
  }

}
