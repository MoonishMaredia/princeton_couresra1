import edu.princeton.cs.algs4.StdOut;

public class DeleteLinkedList20<Item> {

    private Node first = null;
    private Node last = null;
    private int size = 0;

    private class Node {

        /**
         * Creates a Node with pointers to a previos value and following value
         *
         * @return No return. Just creates an instance of the node
         */

        Item item;
        Node next;
        Node prev;
    }

    public void add(Item item) {

        /**
         * Adds item to the linked list
         * If linked list is empty, then first and last pointers are set to applicable node
         * Updates the necessary pointers for "prev" and "next" with addition of the element
         * @return No return. Just creates an instance of the node
         */


        if (size == 0) {
            first = new Node();
            first.item = item;
            last = first;
            first.next = null;
            first.prev = null;
        } else {
            Node oldfirst = first;
            first = new Node();
            first.item = item;
            first.next = oldfirst;
            first.prev = null;
            oldfirst.prev = first;
        }
        size++;
    }

    public Item delete(int k) {

        /**
         * Removes the element at index k for the Linked List
         * If index is not applicable for size of Linked List. It will throw an error
         * Updates the necessary pointers for "prev" and "next" with deleteion of the element
         * @return Item. Item resulting from the deletion of the node
         */

        if ((k > size - 1) || (k < 0))
            throw new IllegalArgumentException("Check index provided to deleted");


        if (k == 0) {
            Node cur_first = first;
            Node delnext = first.next;
            delnext.prev = null;
            first = delnext;
            Item ret = cur_first.item;
            cur_first = null;
        } else if (k == size - 1) {
            Node cur_last = last;
            Node delprev = last.prev;
            delprev.next = null;
            last = delprev;
            Item ret = cur_last.item;
            cur_last = null;
        } else {
            Node cur_first = first;
            for (int i = 0; i < k; i++) {
                first = first.next;
            }
            Node delprev = first.prev;
            Node delnext = first.next;
            delprev.next = delnext;
            delnext.prev = delprev;
            Item ret = first.item;
            first = null;
            first = cur_first;
            cur_first = null;
        }
        size--;

        return ret;
    }

    public void display() {

        /**
         * Prints the elements of the Linked List to the terminal
         * @return no return
         */

        Node current = first;
        while (!(current == null)) {
            StdOut.println(current.item);
            current = current.next;
        }
    }

    public static void main(String[] args) {
//        DeleteLinkedList20<Integer> test = new DeleteLinkedList20<Integer>();
//        test.add(1);
//        test.add(2);
//        test.add(3);
//        test.add(4);
//        test.add(5);
//        test.add(6);
//        test.add(7);
//        test.add(8);
//        test.add(9);
//        System.out.println("First Display");
//        test.display();
//        test.delete(8);
//        System.out.println("Second Display");
//        test.display();
    }
}
