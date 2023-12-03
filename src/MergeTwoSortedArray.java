import java.util.Arrays;

public class MergeTwoSortedArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;
        for(int j = m; j < nums1.length; j++){
            nums1[j] = nums2[i];
            i++;
        }
        Arrays.sort(nums1);
        System.out.println(Arrays.toString(nums1));
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{1,2,3,0,0,0};
        int[] arr2 = new int[]{2,5,6};
        int m = 3;
        int n = 3;
        merge(arr1,m,arr2,n);
    }
}
