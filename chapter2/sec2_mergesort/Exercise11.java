import edu.princeton.cs.algs4.StdRandom;

@SuppressWarnings("unchecked")

public class Exercise11 {

    private final static int cutoff = 15;

    public static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {

        //Skip the merge if array already ordered
        if ((a[mid].compareTo(a[mid + 1])) <= 0)
            return;

        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        int i = lo;
        int j = mid + 1;

        for (int k = lo; k <= hi; k++)
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > hi) {
                a[k] = aux[i++];
            } else if (aux[i].compareTo(aux[j]) <= 0) {
                a[k] = aux[i++];
            } else {
                a[k] = aux[j++];
            }
    }

    public static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {


        //Use Insertion Sort if array length is less than or equal to cutoff
        if ((hi - lo) <= cutoff) {
            Exercise11.insertion(a, lo, hi);
        } else {
            int mid = lo + (hi - lo) / 2;
            sort(a, aux, lo, mid);
            sort(a, aux, mid + 1, hi);
            merge(a, aux, lo, mid, hi);

        }
    }

    public static void sort(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];
        sort(a, aux, 0, a.length - 1);
    }

    public static Comparable[] genrandom(int n) {

        /**
         * Useful as first step in main client to generate a list of random integers
         * that we will sort
         * Items printed to standard output which can then be passed to a file
         * @input: No input
         * @return No return, only standard output
         */

        Comparable[] arr = new Comparable[n];

        for (int i = 0; i < n; i++) {
            arr[i] = StdRandom.uniform(-n / 2, n / 2);
        }

        return arr;
    }

    public static boolean isSorted(Comparable[] a) {

        /**
         * Useful as first step in main client to generate a list of random integers
         * that we will sort
         * Items printed to standard output which can then be passed to a file
         * @input: No input
         * @return No return, only standard output
         */

        for (int i = 1; i < a.length; i++) {
            if ((a[i].compareTo(a[i - 1])) < 0) {
                return false;
            }
        }
        return true;
    }

    public static void insertion(Comparable[] arr, int lo, int hi) {

        /**
         * Uses a variant of insertion sort to sort an array of integers
         * Limits total # by shifting array values to right
         * Instead of using exch function to shift values
         * @input: integer array, a
         * @return sorts passed array, a
         */

        if (hi <= lo)
            return;

        for (int i = lo + 1; i <= hi; i++) {
            Comparable val = arr[i];
            int j = i;
            while ((j > lo) && less(val, arr[j - 1])) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = val;
        }
    }

    private static boolean less(Comparable v, Comparable w) {

        /**
         * Returns boolean evaluating whether integer v is less than w
         * @input: two integers.
         * @return boolean. True or False
         */

        return v.compareTo(w) <= 0;
    }


    public static void main(String[] args) {

        Comparable[] a = Exercise11.genrandom(100000);

        System.out.println(isSorted(a));

        long startime = System.nanoTime();
//        Exercise11.insertion(a, 0, a.length - 1);
        Exercise11.sort(a);
        long endtime = System.nanoTime();
        long timeElapsed = endtime - startime;
        System.out.println("Execution Time in nanoseconds : " + timeElapsed);
        System.out.println(isSorted(a));


    }
}
