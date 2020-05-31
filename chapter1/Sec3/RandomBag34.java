import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;

public class RandomBag34<Item> implements Iterable<Item> {

    private Item[] arr = (Item[]) new Object[1];
    private int size = 0;

    public boolean isEmpty() {
        return (size == 0);
    }

    public int size() {
        return size;
    }

    public void addItem(Item item) {

        /**
         * Adds item to the bag.
         * Resizes array to 2x its original length if adding to last element of array
         * @input: item. Item to be added into the array
         * @return No return.
         */

        if (arr.length == size) resize(arr.length * 2);
        arr[size] = item;
        size++;
    }

    public void resize(int max) {

        /**
         * Resizes the array "arr" so that it is equal to provided parameter size.
         * Modifies the array size and copies over existing element in same order
         * @input: max. Size you want for the resulting array
         * @return No return.
         */

        Item[] temp = (Item[]) new Object[max];

        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }
        arr = temp;
        temp = null;
    }

    public Iterator<Item> iterator() {

        /**
         * Creates an iterator object for your class so you can iterate over
         * @return iterator class object
         */

        return new BagIterator();
    }

    private class BagIterator implements Iterator<Item> {

        /**
         * Creates an implementation for Iterator class of objects
         * has Next method checks if there is a next element in array iteration
         * next method prints the item of the node next in the iteration cycle
         *
         * @return values for hasNext and next methods
         */

        private Item[] arr2;
        private int size2 = size;
        private int index = 0;

        private BagIterator() {
            arr2 = (Item[]) new Object[size];
            for (int i = 0; i < arr.length; i++) {
                arr2[i] = arr[i];
            }
            StdRandom.shuffle(arr2);
        }

        public boolean hasNext() {
            return (index < size2);
        }

        public Item next() {
            if (hasNext() == true) {
                Item item = arr2[index];
                index++;
                return item;
            } else throw new IllegalArgumentException("End of Array. Arrays has no next");
        }
    }

    public static void main(String[] args) {
        RandomBag34<Integer> bag1 = new RandomBag34<Integer>();
        bag1.addItem(1);
        bag1.addItem(2);
        bag1.addItem(3);
        bag1.addItem(4);
        bag1.addItem(5);
        bag1.addItem(6);
        bag1.addItem(7);
        bag1.addItem(8);

        Iterator<Integer> iterator = bag1.iterator();
        System.out.println("Iterator");
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
    }
}
