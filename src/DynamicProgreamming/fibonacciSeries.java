package DynamicProgreamming;

import com.sun.tools.javac.Main;

import java.util.Arrays;

public class fibonacciSeries {
    public static void main(String[] args) {
        fibonacciSeries obj = new fibonacciSeries();
        int n = 6;
        int[] dp = new int[n + 1];

//        Arrays.fill(dp, -1);

        System.out.println(obj.fibBottomUp(n, dp));
    }

    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

    public int fib(int n, int[] dp) {
        if (n <= 1) {
            return n;
        }
        if (dp[n] != -1) return dp[n];
        return dp[n] = fib(n - 1, dp) + fib(n - 2, dp);
    }

    public int fibBottomUp(int n, int[] dp){
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
