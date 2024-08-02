package LeetCode;

public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 0; i < prices.length; i++){
            for (int j = i+1; j < prices.length; j++){
                if(prices[j] - prices[i] > profit){
                    profit = prices[j] - prices[i] ;
                }
            }
        }
        return profit;
    }

    public int maxProfit1(int[] prices) {
        int maxProfit = 0;
        int buy = prices[0];
        for(int i = 1; i < prices.length; i++){
            if(buy > prices[i])
                buy = prices[i];
            else if(prices[i] - buy > maxProfit)
                maxProfit = prices[i] - buy;
        }
        return maxProfit;
    }
}
