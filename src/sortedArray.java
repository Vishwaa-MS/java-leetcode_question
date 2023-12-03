public class sortedArray {
    public boolean check(int[] nums) {
        for (int i=0; i< nums.length; i++){
            for(int j=i+1; j<nums.length;j++){
                if(nums[i]>nums[j]){
                    return false;
                }
            }
        }
        return true;
    }
}
