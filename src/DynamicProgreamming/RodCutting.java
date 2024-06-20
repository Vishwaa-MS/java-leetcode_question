package DynamicProgreamming;

import java.util.Arrays;

public class RodCutting {
    public static void main(String[] args) {
        int[] arr = {1, 5, 8, 9, 10, 17, 17, 20};
        System.out.println(RodCutting(7, 8, arr));
    }

    public static int rodCutting(int ind, int N, int[] price, int[][] dp) {
        if (ind == 0) {
            return N * price[0];
        }

        if (dp[ind][N] != -1) return dp[ind][N];

        int notTake = rodCutting(ind - 1, N, price, dp);
        int take = (int) -1e9;
        int rodLength = ind + 1;
        if (rodLength <= N) take = price[ind] + rodCutting(ind, N - rodLength, price, dp);

        return dp[ind][N] = Math.max(notTake, take);
    }

    public static int RodCutting(int ind, int N, int[] price) {
        int[][] dp = new int[N][N + 1];
        for (int[] row : dp) {
            Arrays.fill(row, 0);
        }


        for (int n = 0; n <= N; n++) {
            dp[0][n] = n * price[0];
        }

        for (int i = 1; i < ind; i++) {
            for (int n = 0; n <= N; n++) {
                int notTake = dp[i - 1][n];
                int take = (int) -1e9;
                int rodLength = i + 1;
                if (rodLength <= n) take = price[i] + dp[i][n - rodLength];

                dp[i][n] = Math.max(notTake, take);
            }
        }
        return dp[ind - 1][N];
    }
}

