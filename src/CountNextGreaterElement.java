import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountNextGreaterElement {
    public static int[] countGreater(int[] arr, int[] query){
        Map<Integer,Integer> map = new HashMap<>() ;

        for(int i=0;i<query.length;i++) {
            map.put(i,query[i]) ;
        }

        int[] ans = new int[query.length] ;

        for(int j = 0; j< query.length; j++){
            int index =  map.get(j);
            int count = 0;
            for(int k = index +1; k < arr.length; k++){
                if(arr[k] > arr [index]) count++;
            }
            ans[j] = count;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1,2,3,4};
        int[] q = new int[] {0,1,2,3};
        System.out.println(Arrays.toString(countGreater(arr, q)));
    }
}
