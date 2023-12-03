import java.util.ArrayList;
import java.util.Collections;

public class RearrangeAlternatingNum {
    public ArrayList<Integer> rearrangeArray(ArrayList<Integer> nums){
        int n = nums.size();
        ArrayList<Integer> arr = new ArrayList<>(Collections.nCopies(n,0));

        int posIndex = 0, negIndex = 1;

        for(int i = 0; i< n;i++){
            if(nums.get(i)<0){
                arr.set(negIndex,nums.get(i));
                negIndex+=2;
            }
            else{
                arr.set(posIndex, nums.get(i));
                posIndex+=2;
            }
        }
        return arr;
    }

    public int[] rearrangeArray(int[] A){
        int n = A.length;
        ArrayList<Integer> pos=new ArrayList<>();
        ArrayList<Integer> neg=new ArrayList<>();

        for(int i=0;i<n;i++){

            if(A[i]>0) pos.add(A[i]);
            else neg.add(A[i]);
        }
        for(int i=0;i<n/2;i++){

            A[2*i] = pos.get(i);
            A[2*i+1] = neg.get(i);
        }


        return A;
    }
}
