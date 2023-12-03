import java.util.Arrays;

public class RemoveDuplicateArray {
    public int[] removeDuplicates(int[] arr) {

        int index = 0;
        int[] newArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            boolean isDuplicate = false;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) {
                newArr[index++] = arr[i];
            }
        }
        return Arrays.copyOf(newArr, index);
    }

    public int removeDup(int[] arr) {
        int j = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                arr[j] = arr[i];
                j++;
            }
        }
        return j;
    }

    public void moveZero(int[] nums) {
//        int n = arr.length;
//        for (int j = 0; j < n; j++) {
//            for (int i = 0; i < n - 1; i++) {
//                if (arr[i] == 0) {
//                    int temp = arr[i];
//                    arr[i] = arr[i + 1];
//                    arr[i + 1] = temp;
//                }
//            }
//        }

        int i = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[i] = num;
                i++;
            }
        }

        while (i <= nums.length - 1) {
            nums[i] = 0;
            i++;
        }

        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
