import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

public class Heapsort {

    public static void sort(Comparable[] arr) {

        int N = arr.length - 1;
        for (int k = N / 2; k >= 1; k--) {
            sink(arr, k, N);
        }

        while (N > 1) {
            exch(arr, 1, N--);
            sink(arr, 1, N);
        }
    }

    public static Comparable[] transform(Comparable[] arr) {

        Comparable[] temp = new Comparable[arr.length + 1];
        for (int i = 0; i <= arr.length; i++) {
            if (i == 0)
                temp[i] = null;
            else
                temp[i] = arr[i - 1];
        }

        arr = temp;
        temp = null;
        return arr;
    }

    public static void sink(Comparable[] arr, int k, int N) {

        while (2 * k <= N) {
            int j = 2 * k;
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

    public static void main(String[] args) {
        Comparable[] arr = new Comparable[20];
        for (int i = 0; i < 20; i++)
            arr[i] = StdRandom.uniform(0, 100);

        System.out.println(Arrays.toString(arr));
        Comparable[] a = transform(arr);
        arr = null;

        System.out.println(Arrays.toString(a));
        Heapsort.sort(a);
        System.out.println(Arrays.toString(a));

    }

}
