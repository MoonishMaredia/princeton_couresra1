import edu.princeton.cs.algs4.StdRandom;

public class HeapsortB {

    public static void sort(Comparable[] arr) {

        int N = arr.length - 1;
        for (int k = N / 2; k >= 0; k--) {
            sink(arr, k, N);
        }

        while (N > 0) {
            exch(arr, 0, N--);
            sink(arr, 0, N);
        }
    }

    public static void sink(Comparable[] arr, int k, int N) {

        while (((2 * k) + 1) <= N) {
            int j = ((2 * k) + 1);
            if ((j < N) && less(arr, j, j + 1)) {
                j++;
            }

            if (less(arr, j, k)) break;
            exch(arr, j, k);
            k = j;
        }
    }

    public static boolean less(Comparable[] arr, int v, int w) {
        return (arr[v].compareTo(arr[w]) < 0);
    }

    public static void exch(Comparable[] arr, int j, int k) {
        Comparable temp = arr[j];
        arr[j] = arr[k];
        arr[k] = temp;
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i].compareTo(a[i + 1]) > 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {

        int timesum = 0;
        int count = 0;
        for (int tries = 0; tries < 10; tries++) {

            int N = 100000;
            Comparable[] arr = new Comparable[N];
            for (int i = 0; i < N; i++)
                arr[i] = StdRandom.uniform(-N / 2, N / 2);

            System.out.println(isSorted(arr));
            long startime2 = System.currentTimeMillis();
            HeapsortB.sort(arr);
            long endtime2 = System.currentTimeMillis();
            long timeElapsed2 = endtime2 - startime2;
            System.out.println("Execution Time in milliseconds : " + timeElapsed2);
            System.out.println(isSorted(arr));
            timesum += timeElapsed2;
            count++;
        }
        System.out.println("Average Execution Time in milliseconds : " + ((float) timesum / count));
    }

}
