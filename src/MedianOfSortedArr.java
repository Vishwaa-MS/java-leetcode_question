
import java.util.*;

public class MedianOfSortedArr {


    // Function to find median of row wise sorted matrix
    public static int Findmedian(int[][] arr, int row, int col) {
        int[] median = new int[row * col];
        int index = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                median[index] = arr[i][j];
                index++;
                //
            }

        }
//        Arrays.parallelSort(median);
        return median[(row * col) / 2];
    }

    public static void main(String args[]) {
        int row = 3, col = 3;
        int[][] arr = {{1, 3, 8},
                {2, 3, 4},
                {1, 2, 5}};


        int[] arr1 = new int[] {9,8};
        StringBuilder s = new StringBuilder();
        for(int num : arr1){
            s.append(num);
        }
        System.out.println(s);

       // System.out.println("The median of the row-wise sorted matrix is: " +
                //Findmedian(arr, row, col));

    }
}

