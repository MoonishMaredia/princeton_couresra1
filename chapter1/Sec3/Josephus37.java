public class Josephus37<Item> {

    private Node last;
    private Node start;
    private int size = 0;

    private class Node {
        Item item;
        Node next;
    }

    public int getSize() {
        return size;
    }

    public void addItem(Item item) {
        if (size == 0) {
            start = new Node();
            start.item = item;
            last = start;
            last.next = start;
        } else {
            Node oldstart = start;
            start = new Node();
            start.item = item;
            start.next = oldstart;
            last.next = start;
        }
        size++;
    }


    public Item delete(int k) {

        for (int i = 1; i < k - 1; i++) {
            start = start.next;
        }

        Item item = start.next.item;
        start.next = start.next.next;
        start = start.next;

        size--;
        return item;
    }

    public Item evaluate(int x) {

//        if (x > size) {
//            int mod = x % size;
//            Item item = delete(x);
//        } else {
        Item item = delete(x);
        return item;
    }

    public void display() {

        Node cur_start = start;
        for (int i = 0; i < size; i++) {
            System.out.println(cur_start.item);
            cur_start = cur_start.next;
        }
    }

    public static void main(String[] args) {
        Josephus37 test = new Josephus37<Integer>();

        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);

        for (int i = n; i >= 1; i--) {
            test.addItem(i);
        }

        test.display();
        System.out.println("Josephus Evaluation");

        if (k == 1) {
            System.out.println("Where Josephus should sit?");
            System.out.println(n);
        } else {
            while (test.getSize() > 1) {
                System.out.println(test.evaluate(k));
            }
            System.out.println("Where Josephus should sit?");
            System.out.println(test.evaluate(k));
        }
    }
}
