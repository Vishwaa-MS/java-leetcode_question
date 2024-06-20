package DynamicProgreamming;

import java.util.Arrays;

public class SubSetSumEqualToTarget {
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4};

        boolean[][] dp = new boolean[5][5];
        for (boolean row[] : dp)
            Arrays.fill(row, false);

        System.out.println(SubsetBUP(3, 4, arr, dp));
        System.out.println(Arrays.deepToString(dp));

    }

    public static boolean SubsetSum(int ind, int target, int[] arr, int[][] dp) {
        if (target == 0) return true;
        if (ind == 0) return (arr[0] == target);

        if (dp[ind][target] != -1)
            return dp[ind][target] != 0;

        boolean notTake = SubsetSum(ind - 1, target, arr, dp);
        boolean take = false;
        if (target >= arr[ind]) {
            take = SubsetSum(ind - 1, target - arr[ind], arr, dp);
        }
        dp[ind][target] = (take || notTake) ? 1 : 0;

        return take || notTake;
    }

    public static boolean SubsetBUP(int ind, int target, int[] arr, boolean[][] dp){
        for(int i = 0; i < arr.length; i++) dp[i][0] = true;
        dp[0][arr[0]] = true;

        for(int i = 1; i < arr.length; i++){
            for(int j = 0; j < target; j++){
                boolean notTake = dp[i-1][j];
                boolean take = false;
                if (target >= arr[ind]) {
                    take = dp[ind - 1][target - arr[ind]];
                }
                dp[ind][target] = (take || notTake) ;
            }
        }
        return dp[arr.length-1][target];
    }
}
