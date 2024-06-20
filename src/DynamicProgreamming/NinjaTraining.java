package DynamicProgreamming;

import java.util.Arrays;

public class NinjaTraining {
    public static void main(String[] args) {
        int[][] training = {{1, 2, 5}, {3, 1, 1}, {3, 3, 3}};
        int n = training.length;
        System.out.println(MaxTraining(n, training));
    }

    public static int MaxTraining(int day, int last, int[][] training, int[][] dp) {
        if (dp[day][last] != -1) return dp[day][last];

        if (day == 0) {
            int maxi = 0;
            for (int i = 0; i <= 2; i++) {
                if (i != last) {
                    maxi = Math.max(maxi, training[0][i]);
                }
            }
            return dp[day][last] = maxi;
        }
        int maxi = 0;
        for (int i = 0; i <= 2; i++) {
            if (i != last) {
                int points = training[day][i] + MaxTraining(day - 1, i, training, dp);
                maxi = Math.max(maxi, points);
            }
        }

        return dp[day][last] = maxi;
    }

    public static int MaxTraining(int n, int[][] training) {
        int[][] dp = new int[n][4];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        int ans = MaxTraining(n - 1, 3, training, dp);
        System.out.println(Arrays.deepToString(dp));
        return ans;
    }

    public static int MaxNinjaBottomUp(int n, int[][] points){
        int[][] dp = new int[n][4];

        dp[0][0] = Math.max(points[0][1], points[0][2]);
        dp[0][1] = Math.max(points[0][0], points[0][2]);
        dp[0][2] = Math.max(points[0][0], points[0][1]);
        dp[0][3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));


        for(int day = 1; day < n; day++){
            for(int last =0; last < 4; last++){
                dp[day][last] = 0;
                for(int task = 0; task < 3; task++){
                    if(task != last){
                        int activity = points[day][task] + dp[day - 1][task];
                        dp[day][last] = Math.max(activity, dp[day][last]);
                    }
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[n-1][3];
    }
}
