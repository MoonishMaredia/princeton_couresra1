import edu.princeton.cs.algs4.StdRandom;

public class BUMergeSort {

    public BUMergeSort() {
        //no constructor needed
    }

    private static Comparable[] aux;


    public static void sort(Comparable[] a) {

        int N = a.length;
        aux = new Comparable[N];
        for (int sz = 1; sz < N; sz = sz + sz) {
            for (int lo = 0; lo < N - sz; lo += sz + sz) {
                merge(a, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));
            }
        }
    }

    public static void merge(Comparable[] a, int lo, int mid, int hi) {

        for (int k = 0; k <= hi; k++) {
            aux[k] = a[k];
        }

        int i = lo;
        int j = mid + 1;


        for (int k = lo; k <= hi; k++) {

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


    public static void main(String[] args) {

        Comparable[] a = BUMergeSort.genrandom(100000);

        System.out.println(isSorted(a));
        long startime2 = System.nanoTime();
        BUMergeSort.sort(a);
        long endtime2 = System.nanoTime();
        long timeElapsed2 = endtime2 - startime2;
        System.out.println("Execution Time BU Mergesort in nanoseconds : " + timeElapsed2);
        System.out.println(isSorted(a));

    }
}
