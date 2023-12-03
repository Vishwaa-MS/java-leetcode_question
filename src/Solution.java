class Solution {
    public static  int minOperations(int[] nums, int x) {
        int target = -x, n = nums.length;
        for (int num : nums) target += num;

        if (target == 0) return n;

        int maxLen = 0, curSum = 0, left = 0;

        for (int right = 0; right < n; ++right) {
            curSum += nums[right];
            while (left <= right && curSum > target) {
                curSum -= nums[left];
                left++;
            }
            if (curSum == target) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }
        return maxLen != 0 ? n - maxLen : -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1,1,4,2,3};
        int x = 5;
        System.out.println(minOperations(arr,x));
    }
}
