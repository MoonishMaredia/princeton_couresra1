import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private Node first = null;
    private Node last = null;
    private int size = 0;

    private class Node {

        // Item for Node and a link to previous and next node
        Item item;
        Node next;
        Node prev;
    }

    public Deque() {
        // explicit constuctor not needed
    }

    // is the deque empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the deque
    public int size() {
        return size;
    }

    // add the item to the front
    public void addFirst(Item item) {

        if (item == null) {
            throw new IllegalArgumentException("Item to be added cannot be null");
        }

        // first node added should initialize as first and last
        if (size == 0) {
            first = new Node();
            first.item = item;
            last = first;
            first.prev = null;
            first.next = null;
        } else {
            Node oldfirst = first;
            first = new Node();
            first.item = item;
            first.next = oldfirst;
            first.prev = null;
            oldfirst.prev = first;
        }

        // increment count for successful adds
        size++;
    }

    // add the item to the back
    public void addLast(Item item) {

        if (item == null) {
            throw new IllegalArgumentException("Item to be added cannot be null");
        }

        // first node added should initialize as first and last
        if (size == 0) {
            last = new Node();
            last.item = item;
            first = last;
            last.prev = null;
            last.next = null;
        } else {
            Node oldlast = last;
            last = new Node();
            last.item = item;
            oldlast.next = last;
            last.prev = oldlast;
            last.next = null;
        }
        // increment count for successful adds
        size++;
    }

    // remove and return the item from the front
    public Item removeFirst() {

        if (size <= 0) {
            throw new NoSuchElementException("Deque is empty");
        }

        Node oldfirst = first;
        first = oldfirst.next;
        --size;

        return oldfirst.item;
    }

    // remove and return the item from the back
    public Item removeLast() {

        if (size <= 0) {
            throw new NoSuchElementException("Deque is empty");
        }

        Node oldlast = last;
        last = oldlast.prev;
        --size;

        return oldlast.item;
    }

    public Iterator<Item> iterator() {
        return new LinkedIterator();
    }

    private class LinkedIterator implements Iterator<Item> {

        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }

    }

    // unit testing (required)
    public static void main(String[] args) {
        Deque<Integer> deque = new Deque<>();
        System.out.println(deque.size());
        deque.addLast(2);
        System.out.println(deque.size());
        System.out.println(deque.isEmpty());
        System.out.println(deque.isEmpty());
        System.out.println(deque.removeFirst());
        deque.addLast(7);
        deque.addLast(8);
        System.out.println(deque.removeFirst());
    }
}
