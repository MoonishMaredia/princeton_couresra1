import java.util.Stack;

public class UnorderedList<Key, Value> {
    private Node first; // first node in the linked list

    private class Node { // linked-list node
        Key key;
        Value val;
        Node next;

        public Node(Key key, Value val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    public Value get(Key key) { // Search for key, return associated value.
        for (Node x = first; x != null; x = x.next)
            if (key.equals(x.key))
                return x.val; // search hit
        return null; // search miss
    }

    public void put(Key key, Value val) { // Search for key. Update value if found; grow table if new.
        for (Node x = first; x != null; x = x.next)
            if (key.equals(x.key)) {
                x.val = val;
                return;
            } // Search hit: update val.
        first = new Node(key, val, first); // Search miss: add new node.
    }

    public Iterable<Key> Keys() {

        Stack<Key> stack1 = new Stack<>();
        Stack<Key> stack2 = new Stack<>();
        Node x = first;

        while (x != null) {
            if (x.val != null) {
                stack1.push(x.key);
            }
            x = x.next;
        }

        while (!stack1.empty()) {
            stack2.push(stack1.pop());
        }

        return stack2;
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

    public static void main(String[] args) {
        // do nothing
    }
}
