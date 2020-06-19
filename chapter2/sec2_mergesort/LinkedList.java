public class LinkedList<Item> {

    public Node first = null;
    private int size = 0;

    public class Node {
        Item item;
        Node next;
    }

    public int getSize() {
        return size;
    }


    public void push(Item a) {
        if (size == 0) {
            first = new Node();
            first.item = a;
        } else {
            Node oldfirst = first;
            first = new Node();
            first.item = a;
            first.next = oldfirst;
        }
        size++;
    }

    public Item pop() {

        if (size == 0)
            throw new IllegalArgumentException("List is null");

        Node popped = first;
        first = first.next;
        popped.next = null;
        Item ret = popped.item;

        size--;
        return ret;
    }


    public void print() {
        Node cur = first;
        while (cur != null) {
            System.out.println(cur.item);
            cur = cur.next;
        }
    }

    public static void main(String[] args) {
//        LinkedList<Integer> test = new LinkedList<Integer>();
//        test.push(4);
//        test.push(1);
//        test.push(99);
//        test.push(10);
//        test.push(2);
//        test.push(-5);
//        test.push(-7);
//        test.push(11);
//        test.push(9);
//        test.push(3);
//        test.push(1);
//        test.push(6);
//        test.push(5);
//        test.push(9);
//        test.push(4);
//        test.push(2);
//        System.out.println("Popping");
//        System.out.println(test.pop());
//        System.out.println(test.pop());
//        System.out.println(test.pop());
//        System.out.println("Printing");
//        test.print();
    }
}
