//2.3.22 Fast 3-way partitioning. ( J. Bentley and D. McIlroy) Implement an entropyoptimal sort based on keeping item's with equal keys at both the left and right ends
//        of the subarray. Maintain indices p and q such that
//        a[lo..p-1] and a[q+1..hi] are all equal to a[lo],
//        an index i such that a[p..i-1] are all less than a[lo],
//        and an index j such that a[j+1..q] are all greater than
//        a[lo]. Add to the inner partitioning loop code to swap
//        a[i] with a[p] (and increment p) if it is equal to v and
//        to swap a[j] with a[q] (and decrement q) if it is equal
//        to v before the usual comparisons of a[i] and a[j]
//        with v. After the partitioning loop has terminated, add
//        code to swap the items with equal keys into position.
//        Note : This code complements the code given in the
//        text, in the sense that it does extra swaps for keys equal to the partitioning item’s key,
//        while the code in the text does extra swaps for keys that are not equal to the partitioning
//        item’s key.


import edu.princeton.cs.algs4.StdRandom;


public class Exercise22 {

    public class myResult {
        private int st;
        private int e1;
        private int st2;
        private int e2;

        public myResult(int w, int x, int y, int z) {
            st = w;
            e1 = x;
            st2 = y;
            e2 = z;
        }
    }

    public void sort(Comparable[] a) {
//        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    public void sort(Comparable[] a, int lo, int hi) {

        if (lo >= hi)
            return;

        myResult res = partition(a, lo, hi);
        sort(a, res.st, res.e1);
        sort(a, res.st2, res.e2);
    }

    public myResult partition(Comparable[] a, int lo, int hi) {

        Comparable val = a[lo];
        int i = lo;
        int p = lo;
        int j = hi + 1;
        int q = hi + 1;

        while (true) {

            if ((i > lo) && (a[i].compareTo(val) == 0))
                exch(a, i, ++p);

            if ((j <= hi) && (a[j].compareTo(val) == 0))
                exch(a, j, --q);

            while (less(a[++i], val)) {
                if (i == hi) break;
            }

            while (less(val, a[--j])) {
                if (j == lo) break;
            }

            if ((i == j) && (a[i].compareTo(val) == 0))
                exch(a, i, ++p);

            if (i >= j) break;
            exch(a, i, j);
        }

        i = j + 1;

        for (int k = lo; k <= p; k++) {
            exch(a, k, j--);
        }

        for (int k = hi; k >= q; k--) {
            exch(a, k, i++);
        }

        myResult res = new myResult(lo, j, i, hi);
        return res;
    }

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[j];
        a[j] = a[i];
        a[i] = temp;
    }


    public static Comparable[] genrandom(int n) {

        Comparable[] arr = new Comparable[n];

        for (int i = 0; i < n; i++) {
            arr[i] = StdRandom.uniform(-n / 2, n / 2);
        }

        return arr;
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i].compareTo(a[i + 1]) > 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {

        Comparable[] a = QuickSort.genrandom(100000);
        Comparable[] b = a.clone();

        Exercise22 sol = new Exercise22();

        System.out.println(QuickSort.isSorted(a));
        long startime1 = System.nanoTime();
        sol.sort(a);
        long endtime1 = System.nanoTime();
        long timeElapsed1 = endtime1 - startime1;
        System.out.println("Execution Time in nanoseconds : " + timeElapsed1);
        System.out.println(isSorted(a));


        System.out.println(isSorted(b));
        long startime2 = System.nanoTime();
        QuickSort.sort(b);
        long endtime2 = System.nanoTime();
        long timeElapsed2 = endtime2 - startime2;
        System.out.println("Execution Time in nanoseconds : " + timeElapsed2);
        System.out.println(isSorted(b));


    }
}
