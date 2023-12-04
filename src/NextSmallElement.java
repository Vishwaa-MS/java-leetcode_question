public class NextSmallElement {
    private void immediateSmaller(int[] a) {
        // Write your code here.
        int n = a.length;
        // Run a loop from index 0
        for (int i = 0; i < n - 1; i++)
        {
            // Check for the next element
            if (a[i + 1] < a[i]) {
                a[i] = a[i + 1];
            } else {
                a[i] = -1;
            }
        }

        // Finally for the last element put it as -1
        a[n - 1] = -1;
    }
}
