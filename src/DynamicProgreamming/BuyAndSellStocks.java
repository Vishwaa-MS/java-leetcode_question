package DynamicProgreamming;

import java.util.Arrays;

public class BuyAndSellStocks {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return maxProfit(0,1,dp, prices);

    }
    public static int maxProfit(int ind, int buy, int[][] dp, int[] prices){
        if(ind == prices.length ) return 0;
        if(dp[ind][buy] != -1) return dp[ind][buy];
        int profit = 0;
        if(buy == 1){
            profit = Math.max(-prices[ind] + maxProfit(ind + 1, 0, dp, prices),  maxProfit(ind + 1, 1, dp, prices));
        } else{
            profit = Math.max(prices[ind] + maxProfit(ind + 1, 1, dp, prices),  maxProfit(ind + 1, 0, dp, prices));
        }
        return dp[ind][buy] = profit;
    }
}
