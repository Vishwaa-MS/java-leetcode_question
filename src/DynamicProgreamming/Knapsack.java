package DynamicProgreamming;

import java.util.Arrays;

public class Knapsack {

    public static void main(String[] args) {

//        int[][] dp = new int[n][w];
//        for (int row[] : dp)
//            Arrays.fill(row, -1);

    }

    public static int knapsack(int ind, int w, int[] W, int[] val, int[][] dp) {
        if (ind == 0) {
            if (W[0] <= w) return val[0];
            else return 0;
        }

        if (dp[ind][w] != -1) return dp[ind][w];

        int notTake = knapsack(ind - 1, w, W, val, dp);
        int take = Integer.MIN_VALUE;
        if (W[ind] <= w) take = val[ind] + knapsack(ind - 1, w - W[ind], W, val, dp);

        return dp[ind][w] = Math.max(notTake, take);
    }

    public static int knapsackBUP(int n, int wt, int[] w, int[] val, int[][] dp) {

        for (int i = w[0]; i <= wt; i++) {
            dp[0][i] = val[0];
        }

        for (int ind = 1; ind < n; ind++) {
            for (int cap = 0; cap <= wt; cap++) {
                int notTake = dp[ind - 1][cap];
                int take = Integer.MIN_VALUE;
                if (w[ind] <= cap) take = val[ind] + dp[ind - 1][cap - w[ind]];
                dp[ind][wt] = Math.max(notTake, take);
            }
        }
        return dp[n - 1][wt];
    }
}
