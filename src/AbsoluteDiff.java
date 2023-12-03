import java.util.ArrayList;

class AbsoluteDiff {
    public static int[] getSumAbsoluteDifferences(int[] nums) {
        ArrayList<Integer> arrL = new ArrayList<>();
        int n = nums.length;
        for(int i = 0; i < n; i++){
            int sum = 0;
            for(int j = 0; j < n; j ++){
                sum += Math.abs(nums[i]-nums[j]);
            }
            arrL.add(sum);
        }
        int[] ans = new int[n];
        for(int k = 0; k < n; k++){
            ans[k] = arrL.get(k);
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}