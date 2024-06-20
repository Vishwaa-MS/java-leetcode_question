package DynamicProgreamming;

import java.util.Arrays;

public class FrogJump {
    public static void main(String[] args) {
        int[] heights = {30, 10, 60, 10, 60, 50};
        int ind = 5;
        FrogJump obj = new FrogJump();
        int[] dp = new int[ind + 1];
        Arrays.fill(dp, -1);
        System.out.println(obj.frogStair(ind, heights, dp));
        System.out.println(Arrays.toString(dp));
    }

    public int frogStair(int ind, int[] height) {
        if (ind == 0) return 0;

        int fs = frogStair(ind - 1, height) + Math.abs(height[ind] - height[ind - 1]);
        int ss = Integer.MAX_VALUE;

        if (ind > 1) {
            ss = frogStair(ind - 2, height) + Math.abs(height[ind] - height[ind - 2]);
        }
        return Math.min(fs, ss);
    }


    public int frogStair(int ind, int[] height, int[] dp) {
        if (ind == 0) return 0;

        int fs = frogStair(ind - 1, height, dp) + Math.abs(height[ind] - height[ind - 1]);
        int ss = Integer.MAX_VALUE;

        if (dp[ind] != -1) {
            return dp[ind];
        }

        if (ind > 1) {
            ss = frogStair(ind - 2, height, dp) + Math.abs(height[ind] - height[ind - 2]);
        }
        return dp[ind] = Math.min(fs, ss);
    }
}
