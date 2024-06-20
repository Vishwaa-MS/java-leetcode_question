package DynamicProgreamming;

import java.util.Arrays;

public class LCS {
    public static void main(String[] args) {
        String text1 = "brute";
        String text2 = "groot";
        int i = text1.length();
        int j = text2.length();

        int[][] dp = new int[i + 1][j + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
    }

    public static int lcs(int ind1, int ind2, String s1, String s2, int[][] dp) {
        if (ind1 == 0 || ind2 == 0) return 0;

        if (dp[ind1][ind2] != -1) return dp[ind1][ind2];

        if (s1.charAt(ind1 - 1) == s2.charAt(ind2 - 1))
            return dp[ind1][ind2] = 1 + lcs(ind1 - 1, ind2 - 1, s1, s2, dp);
        return dp[ind1][ind2] = Math.max(lcs(ind1 - 1, ind2, s1, s2, dp), lcs(ind1, ind2 - 1, s1, s2, dp));
    }
}
