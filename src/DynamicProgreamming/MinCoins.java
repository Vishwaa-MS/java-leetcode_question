package DynamicProgreamming;

public class MinCoins {

    public static void main(String[] args) {

    }

    public static int minCoins(int ind, int target, int[] coins, int[][] dp){
        if(ind == 0){
            if(target % coins[ind] == 0) return target / coins[ind];
            else  return (int) 1e9;
        }
        if(dp[ind][target] != -1) return dp[ind][target];
        int notTake = minCoins(ind - 1, target, coins, dp);
        int take = (int) 1e9;
        if(coins[ind] <= target) take = 1 + minCoins(ind, target - coins[ind], coins, dp);

        return dp[ind][target] = Math.min(notTake, take);
    }

    static int minimumElements(int[] arr, int T) { 
        int n = arr.length;

        // Create a 2D array to store results of subProblems
        int dp[][] = new int[n][T + 1];

        // Initialize the dp array for the first element of the array
        for (int i = 0; i <= T; i++) {
            if (i % arr[0] == 0)
                dp[0][i] = i / arr[0];
            else
                dp[0][i] = (int) Math.pow(10, 9);
        }

        // Fill the dp array using dynamic programming
        for (int ind = 1; ind < n; ind++) {
            for (int target = 0; target <= T; target++) {
                int notTake = dp[ind - 1][target];
                int take = (int) Math.pow(10, 9);

                // If the current element is less than or equal to the target, calculate 'take'
                if (arr[ind] <= target)
                    take = 1 + dp[ind][target - arr[ind]];

                // Store the minimum result in the dp array
                dp[ind][target] = Math.min(notTake, take);
            }
        }

        // Get the minimum number of elements needed for the target sum
        int ans = dp[n - 1][T];

        // If it's not possible to achieve the target sum, return -1
        if (ans >= (int) Math.pow(10, 9))
            return -1;
        return ans;
    }
}

