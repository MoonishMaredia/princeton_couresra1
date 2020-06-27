import edu.princeton.cs.algs4.StdRandom;


public class Exercise25 {

//2.1.25 Insertion sort without exchanges. Develop an implementation of insertion sort
//    that moves larger elements to the right one position with one array access per entry,
//    rather than using exch(). Use SortCompare to evaluate the effectiveness of doing so.


    private static boolean less(int v, int w) {

        /**
         * Returns boolean evaluating whether integer v is less than w
         * @input: two integers.
         * @return boolean. True or False
         */

        return v < w;
    }

    private static void exch(int[] a, int i, int j) {

        /**
         * Swaps the elements at index i and index j in array a
         * @input: array and two indices within the array
         * @return No return
         */

        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void sort1(int[] arr) {

        /**
         * Uses a variant of insertion sort to sort an array of integers
         * Limits total # by shifting array values to right
         * Instead of using exch function to shift values
         * @input: integer array, a
         * @return sorts passed array, a
         */

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

    public static void sort2(int[] a) {

        /**
         * Uses insertion sort to sort an array of integers
         * @input: integer array, a
         * @return sorts passed array, a
         */

        int N = a.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--)
                exch(a, j, j - 1);
        }
    }

    public static int[] genrandom(int n) {

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = StdRandom.uniform(-n / 2, n / 2);
        }

        return arr;
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

    public static double time(String alg, int[] a) {
        Stopwatch timer = new Stopwatch();
        if (alg.equals("sort1")) Exercise25.sort1(a);
        if (alg.equals("sort2")) Exercise25.sort2(a);
        return timer.elapsedTime();
    }

    public static void main(String[] args) {

        int[] a = Exercise25.genrandom(100000);
        int[] b = a.clone();

        System.out.println(Exercise25.isSorted(a));
        System.out.println(Exercise25.time("sort1", a));
        System.out.println(Exercise25.isSorted(a));


        System.out.println(Exercise25.isSorted(b));
        System.out.println(Exercise25.time("sort2", b));
        System.out.println(Exercise25.isSorted(b));

        //Result:
        //Without exchanges, insertion sort is ~77% faster
        //when sorting an array of size 500K
        //Sort1: 18.43 seconds
        //Sort2: 32.69 seconds
    }
}
