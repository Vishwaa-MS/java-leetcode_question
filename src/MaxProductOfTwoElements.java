public class MaxProductOfTwoElements {
    public static int maxProduct(int[] nums) {
        int ans = 0;
        for(int i = 0; i < nums.length; i++){
            for(int j = i; j < nums.length; j++){
                ans = Math.max( ans, (nums[i]-1)*(nums[j]-1) );
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,4,5,2};
        System.out.println(maxProduct(arr));
    }
}
