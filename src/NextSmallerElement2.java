import java.util.Arrays;
import java.util.Stack;

public class NextSmallerElement2 {
    public static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] nge = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && st.peek() >= nums[i]) {
                st.pop();
            }
            if (!st.isEmpty()) nge[i] = st.peek();
            else nge[i] = -1;
            st.add(nums[i]);
        }
        return nge;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4,5,2,10,8};
        System.out.println(Arrays.toString(nextGreaterElements(arr)));
    }

}
