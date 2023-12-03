public class FindPeakElement2 {

    public static int[] peakGrid(int[][] mat) {
        int col = mat[0].length;
        int low = 0;
        int high = col - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int row = maxElement(mat, mid);
            int left = mid - 1 >= 0 ? mat[row][mid - 1] : -1;
            int right = mid + 1 < col ? mat[row][mid + 1] : -1;

            if (mat[row][mid] > left && mat[row][mid] > right) {
                return new int[]{row, mid};
            } else if (mat[row][mid] < left) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return new int[]{-1, -1};
    }


    public static int maxElement(int[][] mat, int mid) {
        int row = 0;
        int max = 0;
        for (int i = 0; i < mat.length; i++) {
            if (mat[i][mid] > max) {
                max = mat[i][mid];
                row = i;
            }
        }
        return row;
    }
}
