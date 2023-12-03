import java.util.ArrayList;
import java.util.List;

public class CombinationSum1 {

    private static void findCombination(int ind, int[] arr, int target, List<List<Integer>> ans, List<Integer> sub) {
        if (ind == arr.length) {
            if (target == 0) {
                ans.add(new ArrayList< >(sub));
            }
            return;
        }

        if (arr[ind] <= target) {
            sub.add(arr[ind]);
            findCombination(ind, arr, target - arr[ind], ans, sub);
            sub.remove(sub.size() - 1);
        }
        findCombination(ind + 1, arr, target, ans, sub);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> sub = new ArrayList<>();
        findCombination(0, candidates, target, ans, sub);
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> ls = combinationSum(arr, target);
        System.out.println("Combinations are: " + ls);
        for (int i = 0; i < ls.size(); i++) {
            for (int j = 0; j < ls.get(i).size(); j++) {
                System.out.print(ls.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

}
