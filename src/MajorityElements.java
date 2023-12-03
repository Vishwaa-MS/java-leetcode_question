import java.util.HashMap;
import java.util.Map;

public class MajorityElements {

    public int majorityElement(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int n = arr.length;

        for (int num : arr) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
/*
        for (Map.Entry<Integer, Integer> currentEntry : map.entrySet()) {
            if (entryWithMaxValue == null || currentEntry.getValue().compareTo(entryWithMaxValue.getValue()) > 0) {
                entryWithMaxValue = currentEntry;
            }
        }
*/
        for (Map.Entry<Integer, Integer> it : map.entrySet()) {
            if (it.getValue() > (n / 2)) {
                return it.getKey();
            }
        }
        return -1;
    }


    //Optimized Approach - Moore's Voting Law

    /*If the array contains a majority element, its occurrence must be greater than the floor(N/2).
    Now, we can say that the count of minority elements and majority elements is equal up to a certain point in the
    array. So when we traverse through the array we try to keep track of the count of elements and the element itself
    for which we are tracking the count.

    After traversing the whole array, we will check the element stored in the variable. If the question states that
     the array must contain a majority element, the stored element will be that one but if the question does not state
     so, then we need to check if the stored element is the majority element or not. If not, then the array does not
     contain any majority element.
    */

    public int majorElement(int []v) {
        //size of the given array:
        int n = v.length;
        int cnt = 0; // count
        int el = 0; // Element

        //applying the algorithm:
        for (int i = 0; i < n; i++) {
            if (cnt == 0) {
                cnt = 1;
                el = v[i];
            } else if (el == v[i]) cnt++;
            else cnt--;
        }

        //checking if the stored element
        // is the majority element:
        int cnt1 = 0;
        for (int i = 0; i < n; i++) {
            if (v[i] == el) cnt1++;
        }

        if (cnt1 > (n / 2)) return el;
        return -1;
    }
}

