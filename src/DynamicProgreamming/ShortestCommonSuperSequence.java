package DynamicProgreamming;

import java.util.Arrays;

public class ShortestCommonSuperSequence {
    public static void main(String[] args) {
        String text1 = "brute";
        String text2 = "groot";
        int i = text1.length();
        int j = text2.length();

        int[][] dp = new int[i + 1][j + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        System.out.println(i+j-lcs(i, j, text1, text2, dp));

        int len = dp.length;
        String ans = "";
        while (i > 0 && j > 0){
            if(text1.charAt(i-1) == text2.charAt(j-1)){
                ans += text1.charAt(i-1);
                i--;
                j--;
            } else if (dp[i-1][j] > dp[i][j-1]) {
                ans += text1.charAt(i-1);
                i--;
            }
            else{
                ans += text2.charAt(j-1);
                j--;
            }
        }
        while(i > 0) {
            ans += text1.charAt(i-1);
            i--;
        }

        while(j > 0){
            ans += text2.charAt(j-1);
            j--;
        }
        System.out.println(new StringBuilder(ans).reverse());

    }

    public static int lcs(int ind1, int ind2, String s1, String s2, int[][] dp) {
        if (ind1 == 0 || ind2 == 0) return 0;

        if (dp[ind1][ind2] != -1) return dp[ind1][ind2];

        if (s1.charAt(ind1 - 1) == s2.charAt(ind2 - 1))
            return dp[ind1][ind2] = 1 + lcs(ind1 - 1, ind2 - 1, s1, s2, dp);
        return dp[ind1][ind2] = Math.max(lcs(ind1 - 1, ind2, s1, s2, dp), lcs(ind1, ind2 - 1, s1, s2, dp));
    }
}
