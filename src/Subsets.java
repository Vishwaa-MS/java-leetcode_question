import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans=new ArrayList<>();
        for (int num = 0; num < (1 << n); num++) {
            List<Integer>temp=new ArrayList<>();
            for (int i = 0; i < n; i++) {
                //check if the ith bit is set or not
                if ((num & (1 << i))!=0) {
                    temp.add(nums[i]);
                }
            }
            if (temp.size() > 0) {
                ans.add(temp);
            }
        }
        ans.sort((o1, o2) -> o1.get(0).compareTo(o2.get(0)));
        return ans;
    }

    public static void main(String[] args) {

    }
}