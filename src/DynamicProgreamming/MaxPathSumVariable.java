package DynamicProgreamming;

import java.util.Arrays;

public class MaxPathSumVariable {

    public static void main(String[] args) {
        int[][] grid = {{2, 1, 3}, {6, 5, 4}, {7, 8, 9}};
        int n = grid.length;
        int m = grid[0].length;

        int maxi = Integer.MIN_VALUE;

        int[][] dp = new int[n][m];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        for (int j = 0; j < m; j++) {
            int ans = maxPathSum(n - 1, j, m, grid, dp);
            maxi = Math.max(maxi, ans);
        }
        System.out.println(maxi);
    }

    public static int maxPathSum(int i, int j, int m, int[][] grid, int[][] dp) {

        if (j < 0 || j >= m) return (int) -1e9;
        if (i == 0) return grid[0][j];

        if (dp[i][j] != -1) return dp[i][j];

        int up = grid[i][j] + maxPathSum(i - 1, j, m, grid, dp);
        int ld = grid[i][j] + maxPathSum(i - 1, j - 1, m, grid, dp);
        int rd = grid[i][j] + maxPathSum(i - 1, j + 1, m, grid, dp);

        return dp[i][j] = Math.max(up, Math.max(ld, rd));
    }
}
