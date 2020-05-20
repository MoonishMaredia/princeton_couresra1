import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private Item[] qarray;
    private int n = 0;

    // construct an empty randomized queue
    public RandomizedQueue() {
        qarray = (Item[]) new Object[2];
    }

    private void resize(int capacity) {
        Item[] copy = (Item[]) new Object[capacity];
        for (int i = 0; i < n; i++) {
            copy[i] = qarray[i];
        }
        qarray = copy;
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return n == 0;
    }

    // return the number of items on the randomized queue
    public int size() {
        return n;
    }

    // add the item
    public void enqueue(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Item to be added cannot be null");
        }
        if (n >= qarray.length / 2) {
            resize(qarray.length * 2);
        }
        qarray[n] = item;
        n++;
    }

    // remove and return a random item
    public Item dequeue() {

        if (isEmpty()) {
            throw new NoSuchElementException("Deque is empty");
        }

        int rand = StdRandom.uniform(0, n);
        Item ret = qarray[rand];
        if (rand != n - 1) {
            qarray[rand] = qarray[n - 1];
        }
        --n;
        qarray[n] = null;
        if (!isEmpty() && n <= qarray.length / 4) {
            resize(qarray.length / 2);
        }

        return ret;
    }

    // return a random item (but do not remove it)
    public Item sample() {
        if (n == 0) {
            throw new NoSuchElementException("Deque is empty");
        }
        int rand = StdRandom.uniform(0, n);
        return qarray[rand];
    }

    public Iterator<Item> iterator() {        // return an independent iterator over items in random order
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator<Item> {

        private int index = 0;
        private final int newLength = n;
        private final Item[] newarray;

        private QueueIterator() {
            newarray = (Item[]) new Object[n];
            for (int i = 0; i < newLength; i++) {
                newarray[i] = qarray[i];
            }
            StdRandom.shuffle(newarray);
        }

        public boolean hasNext() {
            return newLength < n;
        }

        public Item next() {
            // implement exception if there is no next
            if (newarray[index] == null)
                throw new NoSuchElementException();
            Item item = newarray[index];
            index++;
            return item;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    // unit testing (required)
    public static void main(String[] args) {
        RandomizedQueue<Integer> rq = new RandomizedQueue<Integer>();
        rq.enqueue(1);
        rq.enqueue(2);
        rq.enqueue(3);
        rq.enqueue(4);
        rq.enqueue(5);
        rq.enqueue(6);
        StdOut.println("Size: " + rq.size());
        StdOut.println(rq.dequeue());
        StdOut.println("Size: " + rq.size());
        Iterator<Integer> it = rq.iterator();
        StdOut.println(it.next());
        StdOut.println(it.next());
        StdOut.println(it.next());
        StdOut.println(it.next());
        StdOut.println(it.next());
        StdOut.println(it.hasNext());
    }
}
