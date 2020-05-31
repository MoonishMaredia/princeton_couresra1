import java.util.Iterator;

public class DequeLinked33<Item> implements Iterable<Item> {

    private Node first;
    private Node last;
    private int size = 0;

    public class Node {
        /**
         * Creates a Node class with pointers to a previos value and following value
         * Also includes designation to store value of Item type for the specific node
         *
         * @return No return. Just creates an instance of the node
         */
        Item item;
        Node prev;
        Node next;
    }

    public boolean isEmpty() {
        /**
         * Checks whether the Deque is empty by checking the size of number of elements
         * @return Boolean value of True or False if size is equal to 0
         */
        return (size == 0);
    }

    public int size() {
        /**
         * @return size of the linked list
         */
        return size;
    }

    public void pushLeft(Item item) {

        /**
         * Adds a new Node in the "beginning" of the linked list by replacing the first pointer
         * If linked list is empty, then first and last pointers are set to applicable node
         * Updates the necessary pointers for "prev" with addition of the element
         * @params item: the item value for the node to be created
         * @return No return. Just creation
         */

        if (size == 0) {
            first = new Node();
            first.item = item;
            last = first;
        } else {
            Node oldfirst = first;
            first = new Node();
            first.item = item;
            first.next = oldfirst;
            oldfirst.prev = first;
        }

        size++;
    }

    public void pushRight(Item item) {

        /**
         * Adds a new Node in the "end" of the linked list by replacing the last pointer
         * If linked list is empty, then first and last pointers are set to new node
         * Updates the necessary pointers for "next" with addition of the element
         * @params item: the item value for the node to be created
         * @return No return. Just creation
         */

        if (size == 0) {
            last = new Node();
            last.item = item;
            first = last;
        } else {
            Node oldlast = last;
            last = new Node();
            last.item = item;
            last.prev = oldlast;
            oldlast.next = last;
        }
        size++;
    }

    public Item popLeft() {
        /**
         * Removes the first node in the linked list
         * Repleaces pointer for the first node with the node following it in the linked list
         * @return returns the Item value for the "poppped" node
         */

        if (size == 0) {
            throw new IllegalArgumentException("No elements in List");
        }

        Node cur_first = first;
        first = first.next;
        size--;

        return cur_first.item;
    }

    public Item popRight() {

        /**
         * Removes the last node in the linked list
         * Repleaces pointer for the last node with the node preeceding it in the linked list
         * @return returns the Item value for the "poppped" node
         */

        if (size == 0) {
            throw new IllegalArgumentException("No elements in List");
        }

        Node cur_last = last;
        last = last.prev;
        size--;

        return cur_last.item;
    }

    public Iterator<Item> iterator() {
        /**
         * Creates an iterator object for your class so you can iterate over
         * @return iterator class object
         */

        return new DequeLinkedIterator();
    }

    private class DequeLinkedIterator implements Iterator<Item> {
        /**
         * Creates an implementation for Iterator class of objects
         * has Next method checks if there is a node next in the iteration cycle
         * next method prints the item of the node next in the iteration cycle
         *
         * @return values for hasNext and next methods
         */

        Node current = first;

        public boolean hasNext() {
            return (current != null);
        }

        public Item next() {
            if (!hasNext()) throw new IllegalArgumentException("List is empty or end of list");

            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    public void display() {

        /**
         * Prints the elements of the Linked List to the terminal
         * @return no return
         */


        Node current = first;

        while (!(current == null)) {
            System.out.println(current.item);
            current = current.next;
        }
    }

    public static void main(String[] args) {
        DequeLinked33<Integer> deque = new DequeLinked33<Integer>();
        deque.pushLeft(1);
        deque.pushRight(2);
        deque.pushRight(3);
        deque.pushRight(4);
        deque.pushRight(5);
        deque.pushRight(6);
        deque.pushRight(7);
        deque.display();
        System.out.println(deque.popLeft());
        System.out.println(deque.popLeft());
        System.out.println(deque.popLeft());
        System.out.println(deque.popLeft());
        Iterator<Integer> iterator = deque.iterator();
        System.out.println("Iterator");
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
    }
}
