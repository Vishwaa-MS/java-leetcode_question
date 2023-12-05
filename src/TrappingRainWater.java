public class TrappingRainWater {
    public static int trapWater(int[] heights) {
        int n = heights.length;
        int res = 0;
        int maxLeft = 0, maxRight = 0;
        int left = 0;
        int right = n - 1;
        while ((left <= right)) {
            if (heights[left] <= heights[right]) {
                if (heights[left] >= maxLeft) {
                    maxLeft = heights[left];
                } else {
                    res += maxLeft - heights[left];
                }
                left++;
            } else {
                if (heights[right] >= maxRight) {
                    maxRight = heights[right];
                } else {
                    res += maxRight - heights[right];
                }
                right--;
            }
        }
        return res;
    }

    static int trap(int[] arr) {
        int n = arr.length;
        int prefix[] = new int[n];
        int suffix[] = new int[n];
        prefix[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = Math.max(prefix[i - 1], arr[i]);
        }
        suffix[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = Math.max(suffix[i + 1], arr[i]);
        }
        int waterTrapped = 0;
        for (int i = 0; i < n; i++) {
            waterTrapped += Math.min(prefix[i], suffix[i]) - arr[i];
        }
        return waterTrapped;
    }
}
