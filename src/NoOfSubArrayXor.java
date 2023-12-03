public class NoOfSubArrayXor {

    public static int xorSubArray(int[] arr, int l){
        int n = arr.length;
        int count = 0;
        for(int i = 0; i < n; i++){
            int xor = 0;
            for(int j = i; j < n; j++){


                xor = xor ^ arr[j];

                if(xor == l) count +=1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {5, 6, 7, 8, 9};
        System.out.println(xorSubArray(arr, 5));
    }
}
