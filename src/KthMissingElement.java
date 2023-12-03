import java.util.ArrayList;

public class KthMissingElement {

    public static int KthMissingNum(int[] vec, int k){
        for (int j : vec) {
            if (j <= k) k++; //shifting k
            else break;
        }
        return k;
    }
    public static void main(String[] args) {
        int[] vec = {2,3,4,7,11};
        int k = 5;
        int ans = KthMissingNum(vec, k);
        System.out.println("The missing number is: " + ans);
    }
}
