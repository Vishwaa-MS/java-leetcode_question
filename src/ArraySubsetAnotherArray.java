import java.util.HashMap;

public class ArraySubsetAnotherArray {

    public static void main(String[] args) {
        long[] a1 = {589, 5847, 959, 258};
        long[] a2 = {258, 25};
        System.out.print(isSubset(a1, a2, a1.length, a2.length));
    }

    public static String isSubset( long a1[], long a2[], long n, long m) {

        if(n < m) return "No";

        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();

        for(long num : a1){
            int value = map1.getOrDefault((int) num, 0);
            map1.put((int) num, value+1);
        }
        for(long num : a2){
            int value = map2.getOrDefault((int) num, 0);
            map2.put((int) num, value+1);
        }

        for(long num : a2){
            if( !map2.containsKey(num) || !(map1.get((int) num) >= map2.get((int) num))){
                return "No";
            }
        }
        System.out.println((int) Math.log10(778) + 1);
        return "Yes";
    }
}
