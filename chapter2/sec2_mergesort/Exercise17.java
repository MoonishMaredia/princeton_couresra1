public class Exercise17<Item> {


    //NOT COMPLETED. WORK IN PROGRESS

    private class Node {
        Item item;
        Node next;

        public Node(Item item) {
            this.item = item;
        }
    }

    private int size = 0;
    private Node first;

    public int size() {
        return size;
    }

    public void add(Item item) {
        if (size == 0) {
            first = new Node(item);
        } else {
            Node oldfirst = first;
            first = new Node(item);
            first.next = oldfirst;
        }
        size++;
    }

    public void add(Item item) {
        if (size == 0) {
            first = new Node(item);
        } else {
            Node oldfirst = first;
            first = new Node(item);
            first.next = oldfirst;
        }
        size++;
    }

    private static Exercise17<Comparable> createList() {

        Exercise17<Comparable> linkedList = new Exercise17<>();

        linkedList.add(4);
        linkedList.add(1);
        linkedList.add(99);
        linkedList.add(10);
        linkedList.add(-52);
        linkedList.add(-7);
        linkedList.add(11);
        linkedList.add(9);
        linkedList.add(3);
        linkedList.add(1);
        linkedList.add(6);
        linkedList.add(5);
        linkedList.add(9);
        linkedList.add(4);
        linkedList.add(2);

        return linkedList;
    }

    private static Exercise17.Node mergesort(Exercise17<Comparable>.Node src) {

        Exercise17<Comparable>.Node lo = src;
        Exercise17<Comparable>.Node mid = src;

        while ()

    }

}

