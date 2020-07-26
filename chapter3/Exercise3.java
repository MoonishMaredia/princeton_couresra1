import java.util.ArrayList;
import java.util.List;

public class Exercise3<Key extends Comparable<Key>, Value> {

    private Node first;
    private int size;

    private class Node {

        Key key;
        Value val;
        Node next;
        Node prev;

        public Node(Key key, Value val, Node next, Node prev) {
            this.key = key;
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }

    public void put(Key key, Value val) {

        if (size == 0) {
            Node add = new Node(key, val, null, null);
            first = add;
            size++;
            return;
        }

        if (key.compareTo(first.key) < 0) {
            Node cur = first;
            Node cur_prev = cur.prev;
            Node add = new Node(key, val, cur, cur_prev);
            cur.prev = add;
            size++;
            first = add;
            return;
        }

        Node x = first;
        while (true) {
            if (key.equals(x.key)) {
                x.val = val;
                return;
            } else if (key.compareTo(x.key) < 0) {
                Node add = new Node(key, val, x, x.prev);
                x.prev.next = add;
                x.prev = add;
                size++;
                return;
            } else if (x.next == null) {
                Node add = new Node(key, val, x.next, x);
                x.next = add;
                size++;
                return;
            }

            x = x.next;
        }
    }

    public Value get(Key key) {
        Node x = first;
        while (x != null) {
            if (key.equals(x.key)) {
                return x.val;
            }
            x = x.next;
        }
        return null;
    }

    public void delete(Key key) {
        Node x = first;
        while (x != null) {
            if (key.equals(x.key)) {
                x.val = null;
                size--;
                return;
            }
            x = x.next;
        }
        throw new IllegalArgumentException("Key not found in the list");
    }

    public boolean contains(Key key) {
        Node x = first;
        while (x != null) {
            if (key.equals(x.key)) {
                return (x.val != null);
            }
            x = x.next;
        }
        return false;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public Iterable<Key> Keys() {

        List<Key> arr = new ArrayList<Key>();
        int i = 0;
        Node x = first;

        while (x != null) {
            if (x.val != null) {
                arr.add(x.key);
            }
            i++;
            x = x.next;
        }
        return arr;
    }

    public void printlist() {
        Node run = first;
        while (run != null) {
            if (run.val == null) {
                run = run.next;
            } else {
                System.out.println("(" + run.key + "," + run.val + ")");
                run = run.next;
            }
        }
    }

    public static void main(String[] args) {
        Exercise3<Integer, String> test = new Exercise3<Integer, String>();
        test.put(1, "name");
        test.put(3, "Mike");
        test.put(0, "my");
        test.put(2, "is");
        test.put(4, "!");
        test.put(5, "Jeff");
        test.printlist();
        System.out.println(test.getSize());

        System.out.println("===Getting Function Test===");
        System.out.println(test.get(2));
        System.out.println(test.get(4));
        System.out.println(test.get(-10));

        System.out.println("===Deleting Function Test===");
        test.delete(2);
        test.delete(4);
        test.delete(3);
        test.printlist();
        System.out.println(test.getSize());

        System.out.println("===Contains Function Test===");
        System.out.println(test.contains(2));
        System.out.println(test.contains(5));
        test.printlist();

        System.out.println("===Get Iterable===");
        Iterable<Integer> itr = test.Keys();
        for (Integer elem : itr) {
            System.out.println(elem);
        }
    }
}
