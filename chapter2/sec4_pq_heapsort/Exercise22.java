//2.4.22 Array resizing. Add array resizing to MaxPQ, and prove bounds like those of
//        Proposition Q for array accesses, in an amortized sense.

import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

public class Exercise22<Key extends Comparable<Key>> {

    private Key[] arr;
    private int size = 0;

    public Exercise22() {
        arr = (Key[]) new Comparable[2];
        arr[0] = null;
    }

    public void insert(Key v) {

        arr[++size] = v;
        swim(size);

        if (arr.length == size + 1)
            resize(2 * arr.length);
    }

    public Key delmax() {

        if (size == 0)
            throw new IllegalArgumentException("Size of PQ is 0. No max value available");

//        System.out.println(Arrays.toString(arr));
//        System.out.println(size);

        Key ret = arr[1];
        exch(arr, 1, size--);
        arr[size + 1] = null;
        sink(1, size);

        if (size + 1 <= arr.length / 4)
            resize(arr.length / 2);

        return ret;
    }

    public Key getMax() {
        return arr[1];
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void resize(int N) {

        Key[] temp = (Key[]) new Comparable[N];
        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }
        arr = temp;
        temp = null;
    }

    public void sink(int k, int N) {

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

    public void swim(int k) {

        while ((k > 1) && (less(arr, k / 2, k))) {
            exch(arr, k / 2, k);
            k = k / 2;
        }
    }

    public boolean less(Key[] arr, int v, int w) {
        return (arr[v].compareTo(arr[w]) < 0);
    }

    public void exch(Key[] arr, int j, int k) {
        Key temp = arr[j];
        arr[j] = arr[k];
        arr[k] = temp;
    }

    public void print() {

        for (int i = 0; i < size; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {

        Exercise22<Integer> PQ = new Exercise22<>();
        for (int i = 0; i < 100; i++) {
            PQ.insert(StdRandom.uniform(0, 100));
        }

//        PQ.insert(1);
//        PQ.insert(3);
//        PQ.insert(7);
//        PQ.insert(4);
//        PQ.insert(8);
//        PQ.insert(2);
//        PQ.insert(6);
//        PQ.insert(5);
//        PQ.insert(10);
//        PQ.insert(9);
//        PQ.insert(11);

//        PQ.insert("T");
//        PQ.insert("S");
//        PQ.insert("R");
//        PQ.insert("P");
//        PQ.insert("N");
//        PQ.insert("O");
//        PQ.insert("A");
//        PQ.insert("E");
//        PQ.insert("I");
//        PQ.insert("H");
//        PQ.insert("G");

        System.out.println("End of Insertion Steps");
        System.out.println(Arrays.toString(PQ.arr));

        System.out.println("Starting Deletion Steps");
        System.out.println(PQ.delmax());
        System.out.println(PQ.delmax());
        System.out.println(PQ.delmax());

        System.out.println("Final Print");
        System.out.println(Arrays.toString(PQ.arr));
    }
}
