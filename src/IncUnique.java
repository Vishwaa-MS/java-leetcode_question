import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

public class IncUnique {

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 2, 1, 7, 1};
//        System.out.println(minIncrementForUnique(nums));
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            int value = map.getOrDefault(num, 0);
            map.put(num, value + 1);
        }

        System.out.println(map);
        int move = 0;
        for (int num : nums) {
            int key = num;
            int val = map.get(num);
            if (val > 1) {
                while (map.containsKey(key + 1)) {
                    key += 1;
                    move += 1;
                }
                move += 1;
                key += 1;
//                do{
//                    move += 1;
//                    key += 1;
//                } while (map.containsKey(key + 1));
                map.put(key, 1);
                map.put(num, map.get(num) - 1);
            }
        }
        System.out.println(move);
        System.out.println(map);
    }

    public static int minIncrementForUnique(int[] nums) {
        int moves = 0;
        Arrays.sort(nums);

        for(int i = 1; i < nums.length; i++){
            if(nums[i] <= nums[i-1]){
                int increment = nums[i-1] + 1 - nums[i];

                moves += increment;

                nums[i] = nums[i-1] + 1;
            }
        }
        return moves;
    }
    public int minIncrementForUniqueFreqCnt(int[] nums) {
        int n = nums.length;
        int max = 0;
        int minIncrements = 0;

        // Find maximum value in array to determine range of frequencyCount array
        for (int val : nums) {
            max = Math.max(max, val);
        }

        // Create a frequencyCount array to store the frequency of each value in nums
        int[] frequencyCount = new int[n + max];

        // Populate frequencyCount array with the frequency of each value in nums
        for (int val : nums) {
            frequencyCount[val]++;
        }

        // Iterate over the frequencyCount array to make all values unique
        for (int i = 0; i < frequencyCount.length; i++) {
            if (frequencyCount[i] <= 1) continue;

            // Determine excess occurrences, carry them over to the next value,
            // ensure single occurrence for current value, and update minIncrements.
            int duplicates = frequencyCount[i] - 1;
            frequencyCount[i + 1] += duplicates;
            frequencyCount[i] = 1;
            minIncrements += duplicates;
        }

        return minIncrements;
    }
}
