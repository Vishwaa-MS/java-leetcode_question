import java.util.*;
public class Arrays {
    public static void main(String[] args) {
        int[] arr = {1,1,2,2,2,3,3};
       removeDuplicates(arr);

    }
    public static int[] removeDuplicates(int[] arr){
        int n = arr.length;
        int i = 0;
        for(int j = 0; j < n; j++){
            if(arr[j] != arr[i]){
                i++;
                arr[i] = arr[j];
            }
        }
        System.out.println(java.util.Arrays.toString(arr));
        return arr;
    }

    public static int[] moveZero(int[] arr){
        int j = -1;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 0){
                j = i;
                break;
            }
        }
        if(j== -1) return arr;

        for(int i = j+1; i < arr.length; i++){
            if(arr[i] != 0){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }
        return arr; 
    }

    public int majorityElement(int[] arr){
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : arr){
            int value = map.getOrDefault(num, 0);
            map.put(num, value + 1);
        }

        for(Map.Entry<Integer, Integer> it : map.entrySet()){
            if(it.getValue() > (n/2)){
                return it.getKey();
            }
        }
        return -1;
    }
}
