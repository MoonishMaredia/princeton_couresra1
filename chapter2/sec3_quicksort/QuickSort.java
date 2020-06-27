import edu.princeton.cs.algs4.StdRandom;

public class QuickSort {


    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    public static void sort(Comparable[] a, int lo, int hi) {

        if (hi <= lo)
            return;

        int pivot = partition(a, lo, hi);
        sort(a, lo, pivot - 1);
        sort(a, pivot + 1, hi);
    }

    public static int partition(Comparable[] a, int lo, int hi) {

//        System.out.println("Entering Partition");

        Comparable val = a[lo];
        int i = lo;
        int j = hi + 1;

        while (true) {
//            System.out.println("Through indices: " + i + " " + j);
//            System.out.println("Vales: " + a[i] + " " + a[j] + " " + val);

            while (less(a[++i], val)) {
                if (i == hi)
                    break;
            }

            while (less(val, a[--j])) {
            }

            if (i >= j) break;
            exch(a, i, j);
        }

        exch(a, lo, j);
        return j;
    }

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[j];
        a[j] = a[i];
        a[i] = temp;
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i].compareTo(a[i + 1]) > 0)
                return false;
        }
        return true;
    }

    public static Comparable[] genrandom(int n) {

        Comparable[] arr = new Comparable[n];

        for (int i = 0; i < n; i++) {
            arr[i] = StdRandom.uniform(-n / 2, n / 2);
        }

        return arr;
    }


    public static void main(String[] args) {

        Comparable[] test = QuickSort.genrandom(10000);
        QuickSort.sort(test);
        System.out.println(QuickSort.isSorted(test));
    }

}
