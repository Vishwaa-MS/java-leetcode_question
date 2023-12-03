import java.util.Arrays;

public class AggressiveCows {
    public static boolean canWePlace(int[] stalls, int dist, int cows) {
        int n = stalls.length;
        int cntCows = 1;
        int lastCow = stalls[0];
        for (int i = 1; i < n; i++) {
            if (stalls[i] - lastCow >= dist) {
                cntCows++;
                lastCow = stalls[i];
            }
            if (cntCows >= cows) return true;
        }
        return false;
    }

    public static int aggressiveCows(int[] stalls, int cows) {
        int n = stalls.length;

        Arrays.sort(stalls);

        int low = 1, high = stalls[n - 1] - stalls[0];

        while (low <= high) {
            int mid = (low + high) / 2;
            if (canWePlace(stalls, mid, cows)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }
}
