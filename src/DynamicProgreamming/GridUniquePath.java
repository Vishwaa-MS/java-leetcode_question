package DynamicProgreamming;

import java.util.Arrays;

public class GridUniquePath {

    public static void main(String[] args) {
        int[][] dp = new int[3][2];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        System.out.println(uniquePBP(3,2, dp));
    }

    public static int uniquePaths(int m, int n) {
        if( m == 2 && n== 2) return 2;
        int[][] dp = new int[m][n];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return uniquePaths(m-1, n-1, dp);
    }

    public static int uniquePaths(int i, int j, int[][]dp){
        if(i == 0 && j == 0) return 1;
        if(i < 0 || j < 0) return 0;
        if(dp[i][j] != -1) return dp[i][j];

        int up = uniquePaths(i-1, j, dp);
        int left = uniquePaths(i, j-1, dp);

        return dp[i][j] = up + left;
    }

    public static int uniquePBP(int m, int n, int[][] dp){

        for(int i= 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 && j == 0) {
                    dp[0][0] = 1;
                    continue;
                }
                int up = 0;
                int left = 0;

                if(i > 0) up = dp[i-1][j];
                if(j > 0) left = dp[i][j - 1];

                dp[i][j] = up + left;
            }
        }
        return dp[m-1][n-1];
    }
}
