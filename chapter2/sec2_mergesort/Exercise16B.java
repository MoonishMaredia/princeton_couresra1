import edu.princeton.cs.algs4.StdRandom;

public class Exercise16B {

    private static Comparable[] aux;
    private static int counter = 0;


    public static void sort(Comparable[] a) {

        int N = a.length;
        aux = new Comparable[N];
        int msize = 1;
        int lo = 0;
        int mid = 0;

        while (msize < N) {

            while ((mid + 1 < N) && (a[mid + 1].compareTo(a[mid]) >= 0))
                mid++;

            if (mid >= N - 1) {
                lo = 0;
                mid = 0;
                continue;
            }

            int hi = mid + 1;

            while ((hi + 1 < N) && (a[hi + 1].compareTo(a[hi]) >= 0))
                hi++;

            merge(a, lo, mid, hi);
            msize = (hi - lo + 1);

            lo = hi + 1;
            mid = hi + 1;
        }
    }

    public static void merge(Comparable[] a, int lo, int mid, int hi) {

//        if ((a[mid].compareTo(a[mid + 1])) <= 0)
//            return;

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

        Comparable[] arr = new Comparable[n];
        for (int i = 0; i < n; i++) {
            arr[i] = StdRandom.uniform(-n / 2, n / 2);
        }

        return arr;
    }

    public static boolean isSorted(Comparable[] a) {

        for (int i = 1; i < a.length; i++) {
            if ((a[i].compareTo(a[i - 1])) < 0) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {

//        Comparable[] a = Exercise16B.genrandom(1000);

        Comparable[] a = {2, 4, 9, 5, 6, 1, 3, 9, 11, -7, -5, -2, 10, 99, 1, -1};
//        Comparable[] a = {4, 3, 2, 1};
//        Comparable[] a = {1, 2, 3, 4};

        System.out.println(isSorted(a));
        long startime2 = System.nanoTime();
        Exercise16B.sort(a);
        long endtime2 = System.nanoTime();
        long timeElapsed2 = endtime2 - startime2;
        System.out.println("Execution Time in nanoseconds : " + timeElapsed2);
        System.out.println(isSorted(a));

    }
}
