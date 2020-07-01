//2.4.33 Index priority-queue implementation. Implement the basic operations in the
//        index priority-queue API on page 320 by modifying Algorithm 2.6 as follows: Change
//        pq[] to hold indices, add an array keys[] to hold the key values, and add an array qp[]
//        that is the inverse of pq[] — qp[i] gives the position of i in pq[] (the index j such that
//        pq[j] is i). Then modify the code in Algorithm 2.6 to maintain these data structures.
//        Use the convention that qp[i] = -1 if i is not on the queue, and include a method
//        contains() that tests this condition. You need to modify the helper methods exch()
//        and less() but not sink() or swim().

import java.util.Arrays;

public class Exercise33<Key extends Comparable<Key>> {

    private int N; //size of priority queue
    private Key[] vals; //takes the key index and returns the object/value associated with that key index
    private int[] pm; //takes the key index and return the position of key index on the heap
    private int[] im; //takes a value representing position on the heap and returns the key index stored at that specific position on the heap

    public Exercise33(int max) {
        vals = (Key[]) new Comparable[max + 1];
        pm = new int[max + 1];
        im = new int[max + 1];
        for (int i = 0; i <= max; i++) pm[i] = -1;
    }

    public void insert(int ki, Key key) {
        N++;
        vals[ki] = key;
        pm[ki] = N;
        im[N] = ki;
        swim(N);
    }

    public int delmin() {
        int indexofmin = im[1];
        System.out.println("Removing key index: " + indexofmin + " with value of " + vals[indexofmin]);
        exch(1, N--);
        sink(1);
        vals[im[N + 1]] = null;
        pm[im[N + 1]] = -1;
        im[N + 1] = -1;
        return indexofmin;
    }

    public Key min() {
        return vals[im[1]];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public boolean contains(int k) {
        return (pm[k] != -1);
    }

    public void swim(int k) {
        while ((k > 1) && less(k, k / 2)) {
            exch(k, k / 2);
            k = k / 2;
        }
    }

    public void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            if ((j < N) && (less(j + 1, j))) j++;
            if (less(k, j)) break;
            exch(k, j);
            k = j;
        }
    }

    public boolean less(int x, int y) {
        return vals[im[x]].compareTo(vals[im[y]]) < 0;
    }

    public void exch(int x, int y) {
        int temp = im[x];
        im[x] = im[y];
        im[y] = temp;
        pm[im[y]] = y;
        pm[im[x]] = x;
    }

    public void printall() {
        System.out.println("Values at given key index: " + Arrays.toString(vals));
        System.out.println("Position of key index in Heap: " + Arrays.toString(pm));
        System.out.println("Key index position in heap: " + Arrays.toString(im));
    }


    public static void main(String[] args) {
        Exercise33<Integer> IPQ = new Exercise33<>(20);
        System.out.println("======Initialize the Array=========");
        IPQ.printall();
        System.out.println("======Insert Operations=========");
        IPQ.insert(1, 10);
        IPQ.insert(2, 15);
        IPQ.insert(3, 14);
        IPQ.insert(4, 6);
        IPQ.insert(5, 2);
        IPQ.insert(6, 9);
        IPQ.insert(7, 11);
        IPQ.insert(8, 8);
        IPQ.insert(9, 4);
        IPQ.insert(10, 1);
        IPQ.insert(11, 5);
        IPQ.insert(12, 0);
        System.out.println("======Pop the Minimum=========");
        IPQ.delmin();
        IPQ.delmin();
        IPQ.delmin();
        System.out.println("======Return the Final Array=========");
        IPQ.printall();
    }


}
