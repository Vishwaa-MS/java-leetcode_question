public class MinSubArraySum {
    //Brute Force
    public static int sumSubArrayMins(int[] arr) {
        int n = arr.length;

        long answer = 0;
        int MOD = 1000000007;

        for (int i = 0; i < n; i++) {
            int currentMinimum = arr[i];
            for (int j = i; j < n; j++) {
                currentMinimum = Math.min(currentMinimum, arr[j]);
                // 'currentMinimum' is the minimum of the array from index 'i' to 'j'.
                answer = (answer + currentMinimum) % MOD;
            }
        }
        // Return 'answer'
        return (int) answer;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4};
        System.out.println((sumSubArrayMins(arr)));
    }

    //Using Monotonic Stack
   

}
