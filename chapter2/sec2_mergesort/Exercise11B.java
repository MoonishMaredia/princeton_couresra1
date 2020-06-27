import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdRandom;

@SuppressWarnings("unchecked")

public class Exercise11B {

    private final static int cutoff = 15;

    public static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {

        int i = lo;
        int j = mid + 1;

        for (int k = lo; k <= hi; k++)
            if (i > mid) {
                aux[k] = a[j++];
            } else if (j > hi) {
                aux[k] = a[i++];
            } else if (a[i].compareTo(a[j]) <= 0) {
                aux[k] = a[i++];
            } else {
                aux[k] = a[j++];
            }
    }

    public static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {

        //Use Insertion Sort if array length is less than or equal to cutoff
        if ((hi - lo) <= cutoff) {
            Exercise11.insertion(aux, lo, hi);
        } else {
            int mid = lo + (hi - lo) / 2;

            sort(aux, a, lo, mid);
            sort(aux, a, mid + 1, hi);

            if (a[mid].compareTo(a[mid + 1]) <= 0) {
                System.arraycopy(a, lo, aux, lo, hi - lo + 1);
                return;
            }

            merge(a, aux, lo, mid, hi);

        }
    }

    public static void sort(Comparable[] a, Comparable[] aux) {
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
//                System.out.println("False Here: " + a[i] + " " + a[i - 1] + " " + i + " " + (i - 1));
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

        int N = args.length;
        In[] streams = new In[N];
        for (int i = 0; i < N; i++)
            streams[i] = new In(args[i]);

        int M = 0;
        while (M < 10) {
            System.out.println(streams[0].readString());
            M++;
        }

//        Comparable[] a = Exercise11.genrandom(100000);
//        Comparable[] b = a.clone();
//        Comparable[] aux = a.clone();
//
//        System.out.println(isSorted(a));
//        long startime = System.nanoTime();
//        Exercise11B.sort(a, aux);
//        long endtime = System.nanoTime();
//        long timeElapsed = endtime - startime;
//        System.out.println("Execution Time All 3 Improvements in nanoseconds : " + timeElapsed);
//        System.out.println(isSorted(aux));
//
//        System.out.println(isSorted(b));
//        long startime2 = System.nanoTime();
//        Exercise11.sort(b);
//        long endtime2 = System.nanoTime();
//        long timeElapsed2 = endtime2 - startime2;
//        System.out.println("Execution Time 2 Improvements in nanoseconds : " + timeElapsed2);
//        System.out.println(isSorted(b));
//
//        double ratio = ((double) timeElapsed / timeElapsed2) * 100;
//        System.out.printf("The first method is %.02f" + " percent faster \n", (100 - ratio));
//        System.out.println("For Array Size of " + a.length);

    }
}
