package DynamicProgreamming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ClimbingStairs {
    public  int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return helper(n, dp);
    }
    public int helper(int n, int[] dp){
        if(n==0) return 1;
        if(n==1) return 1;

        int left = helper(n-1, dp);
        int right = helper(n-2, dp);
        if(dp[n] != -1) return dp[n];
        return dp[n] = left + right;
    }

    public int climbStair(int n) {
        Map<Integer, Integer> memo = new HashMap<>();
        return climbStairs(n, memo);
    }

    private int climbStairs(int n, Map<Integer, Integer> memo) {
        if (n == 0 || n == 1) {
            return 1;
        }
        if (!memo.containsKey(n)) {
            memo.put(n, climbStairs(n-1, memo) + climbStairs(n-2, memo));
        }
        return memo.get(n);
    }
    public static void main(String[] args) {
        ClimbingStairs ob = new ClimbingStairs();
        System.out.println(ob.climbStairs(50));
    }
}