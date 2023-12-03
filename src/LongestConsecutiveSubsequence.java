import java.util.ArrayList;
import java.util.Arrays;

public class LongestConsecutiveSubsequence {

    public static int longestSeq(int[] a){
        int n = a.length; //size of array
        int longest = 1;
        //pick a element and search for its
        //consecutive numbers:
        for (int j : a) {
            int x = j;
            int cnt = 1;
            //search for consecutive numbers
            //using linear search:
            while (linearSearch(a, x + 1)) {
                x += 1;
                cnt += 1;
            }

            longest = Math.max(longest, cnt);
        }
        return longest;
    }

    public static boolean linearSearch(int []a, int num) {
        int n = a.length; //size of array
        for (int j : a) {
            if (j == num)
                return true;
        }
        return false;
    }


//Better Approach

    public static int longestSuccessiveElements(int []a) {
        int n = a.length;
        if (n == 0) return 0;

        //sort the array:
        Arrays.sort(a);
        int lastSmaller = Integer.MIN_VALUE;
        int cnt = 0; 
        int longest = 1;

        //find longest sequence:
        for (int i = 0; i < n; i++) {
            if (a[i] - 1 == lastSmaller) {
                //a[i] is the next element of the
                //current sequence.
                cnt += 1;
                lastSmaller = a[i];
            } else if (a[i] != lastSmaller) {
                cnt = 1;
                lastSmaller = a[i];
            }
            longest = Math.max(longest, cnt);
        }
        return longest;
    }


    public static void main(String[] args) {
        int[] arr = new int[] {3,8,5,7,6};
        System.out.println(longestSeq(arr));
    }
}
