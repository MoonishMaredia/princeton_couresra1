import edu.princeton.cs.algs4.In;

public class Insertion {

    private static boolean less(int v, int w) {

        /**
         * Returns boolean evaluating whether integer v is less than w
         * @input: two integers.
         * @return boolean. True or False
         */

        return v < w;
    }

    public static void sort1(int[] arr) {

        /**
         * Uses a variant of insertion sort to sort an array of integers
         * Limits total # by shifting array values to right
         * Instead of using exch function to shift values
         * @input: integer array, a
         * @return sorts passed array, a
         */

        System.out.println("Using Insertion Sort");

        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int val = arr[i];
            int j = i;
            while ((j > 0) && less(val, arr[j - 1])) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = val;
        }
    }

    public static void sort2(int[] arr, int lo, int hi) {

        /**
         * Uses a variant of insertion sort to sort an array of integers
         * Limits total # by shifting array values to right
         * Instead of using exch function to shift values
         * @input: integer array, a
         * @return sorts passed array, a
         */

        for (int i = lo + 1; i <= hi; i++) {
            int val = arr[i];
            int j = i;
            while ((j > lo) && less(val, arr[j - 1])) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = val;
        }
    }

    public static boolean isSorted(int[] a) {

        /**
         * Useful as first step in main client to generate a list of random integers
         * that we will sort
         * Items printed to standard output which can then be passed to a file
         * @input: No input
         * @return No return, only standard output
         */

        for (int i = 1; i < a.length; i++) {
            if (a[i - 1] > a[i])
                return false;
        }
        return true;

    }

    public static void main(String[] args) {

        int[] a = In.readInts(args[0]);

        System.out.println(isSorted(a));

        long startime = System.nanoTime();
        Insertion.sort2(a, 0, a.length - 1);
        long endtime = System.nanoTime();
        long timeElapsed = endtime - startime;
        System.out.println("Execution Time in nanoseconds : " + timeElapsed);

        System.out.println(isSorted(a));

    }
}
