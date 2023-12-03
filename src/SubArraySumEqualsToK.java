import java.util.HashMap;

public class SubArraySumEqualsToK {
    public static int subArraySum(int[] nums, int k) {
        int sum = 0;
        int ans = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for(int j=0;j<nums.length;j++){
            sum += nums[j];
            if(map.containsKey(sum -k)){
                ans += map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{1,1,1};
        System.out.println(subArraySum(arr,2));
    }
}
