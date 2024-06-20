package DynamicProgreamming;

import java.util.Arrays;

public class MinCostClimbingStairs {
    public static void main(String[] args) {
        int[] arr = {10,15,20};
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        System.out.println(Math.min(helper(arr, n-1, dp) , helper(arr, n-2, dp)));
        System.out.println(bottomUp(arr, dp));
        System.out.println(spaceOptimization(arr));
    }

    public static int helper(int[] arr, int ind, int[] dp){
        if(ind == 0 || ind == 1) return arr[ind];

        if(dp[ind] != -1) return dp[ind];

        int fs = helper(arr, ind-1, dp) + arr[ind];
        int ss = helper(arr, ind-2, dp) + arr[ind];


        return dp[ind] = Math.min(fs, ss);
    }

    public static int bottomUp(int[] arr, int[] dp){
        dp[0] = arr[0];
        dp[1] = arr[1];
        for(int i = 2; i < arr.length; i++){
            dp[i] = arr[i] + Math.min(dp[i-1], dp[i-2]);
        }
        return Math.min(dp[dp.length-1], dp[dp.length-2]);
    }
    public static int spaceOptimization(int[] arr){
        int prev2 = arr[0];
        int prev= arr[1];
        for(int i = 2; i < arr.length; i++){
           int curr = arr[i] + Math.min(prev, prev2);
           prev2 = prev;
           prev = curr;
        }
        return Math.min(prev, prev2);
    }
}
