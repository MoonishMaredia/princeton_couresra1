import edu.princeton.cs.algs4.StdRandom;

public class Exercise19 {

    private static int inversion_count = 0;

    public static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {

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
                inversion_count += (mid - i + 1);
            }
    }

    public static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {

        if (hi <= lo)
            return;

        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);
        merge(a, aux, lo, mid, hi);

    }

    public static void sort(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];
        sort(a, aux, 0, a.length - 1);
    }

    public static int getInversion_count(Comparable[] a) {

        sort(a);
        return inversion_count;

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

//        Comparable[] a = Exercise19.genrandom(100000);

        Comparable[] a = {'E', 'X', 'A', 'M', 'P', 'L', 'E'};

        System.out.println(isSorted(a));
        System.out.println(Exercise19.getInversion_count(a));
        System.out.println(isSorted(a));

    }
}
