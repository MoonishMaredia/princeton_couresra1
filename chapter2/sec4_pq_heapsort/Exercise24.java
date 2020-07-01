public class Exercise24<Key extends Comparable<Key>> {

    private Node first;
    private Node cur;
    private int size = 0;
    private Node traverse;

    public class Node {
        Key key;
        Node left;
        Node right;
        Node parent;

        public Node(Key key) {
            this.key = key;
        }
    }

    public void insert(Key key) {

        if (size == 0) {
            Node ins = new Node(key);
            ins.parent = null;
            first = ins;
            cur = first;
            size++;

        } else {
            Node ins = new Node(key);
            cur = first;
            String bitwise = bitcalc(size + 1);
            int i = 1;
            while (bitwise.length() > i + 1) {
                if (bitwise.substring(i, i + 1).equals("0")) {
                    cur = cur.left;
                    i++;
                } else {
                    cur = cur.right;
                    i++;
                }
            }
            if (bitwise.substring(i, i + 1).equals("0")) {
                cur.left = ins;
                ins.parent = cur;
                Node test = swim(ins);
                if (less(first.key, test.key)) first = test;

            } else {
                cur.right = ins;
                ins.parent = cur;
                Node test = swim(ins);
                if (less(first.key, test.key)) first = test;
            }
            size++;
        }
    }

    public Key delmax() {
        if (size == 0)
            throw new IllegalArgumentException("Size is 0. Nothing to return");
        Key ret = first.key;
        String bitwise = bitcalc(size);
        int i = 1;
        cur = first;
        while (bitwise.length() >= i + 1) {
            if (bitwise.substring(i, i + 1).equals("0")) {
                cur = cur.left;
                i++;
            } else {
                cur = cur.right;
                i++;
            }
        }
        if (bitwise.substring(i - 1, i).equals("0")) {
            cur.parent.left = null;
            cur.parent = null;
        } else {
            cur.parent.right = null;
            cur.parent = null;
        }

        first.key = cur.key;
        sink(first);
        size--;

        return ret;
    }

    private Node swim(Node src) {

        while ((src.parent != null) && less(src.parent.key, src.key)) {
            Key temp = src.parent.key;
            src.parent.key = src.key;
            src.key = temp;
            src = src.parent;
        }
        return src;
    }

    private void sink(Node src) {

        while ((src.left != null) | (src.right != null)) {

            if (src.right == null) {
                Key temp = src.left.key;
                if (less(temp, src.key)) break;
                src.left.key = src.key;
                src.key = temp;
                src = src.left;

            } else if (less(src.left.key, src.right.key)) {
                Key temp = src.right.key;
                if (less(temp, src.key)) break;
                src.right.key = src.key;
                src.key = temp;
                src = src.right;

            } else {
                Key temp = src.left.key;
                if (less(temp, src.key)) break;
                src.left.key = src.key;
                src.key = temp;
                src = src.left;
            }
        }
    }

    private boolean less(Key v, Key w) {
        return v.compareTo(w) < 0;
    }

    public static String bitcalc(int k) {

        int exp = 0;
        while (true) {
            if (k == Math.pow(2, exp)) break;
            else if (k > Math.pow(2, exp)) exp++;
            else if (k == 0) break;
            else {
                exp--;
                break;
            }
        }

        String res = "";
        while (exp >= 0) {
            if (Math.pow(2, exp) <= k) {
                res += '1';
                k -= Math.pow(2, exp);
                exp--;
            } else {
                res += '0';
                exp--;
            }
        }
        return res;
    }

    private void mtraverse(String cmd) {
        if (cmd == "l") {
            System.out.println(traverse.left.key);
            traverse = traverse.left;
        }
        if (cmd == "r") {
            System.out.println(traverse.right.key);
            traverse = traverse.right;
        }
        if (cmd == "p") {
            System.out.println(traverse.parent.key);
            traverse = traverse.parent;
        }
    }

    private void restraverse() {
        traverse = first;
    }

    private void printfirst() {
        System.out.println(first.key);
    }


    public static void main(String[] args) {
        Exercise24<Integer> PQL = new Exercise24<>();
        PQL.insert(5000);
        PQL.insert(3000);
        PQL.insert(500);
        PQL.insert(250);
        PQL.insert(10);
        PQL.insert(5);
        PQL.insert(1);
        PQL.insert(4000);
        PQL.insert(4001);

        System.out.println("Print Iteration 1");
        PQL.restraverse();
        PQL.printfirst();
        PQL.mtraverse("l");
        PQL.mtraverse("l");
        PQL.mtraverse("l");

        System.out.println("Print Iteration 2");
        PQL.restraverse();
        PQL.printfirst();
        PQL.mtraverse("l");
        PQL.mtraverse("l");
        PQL.mtraverse("r");

        System.out.println("Print Iteration 3");
        PQL.restraverse();
        PQL.printfirst();
        PQL.mtraverse("l");
        PQL.mtraverse("r");

        PQL.insert(7000);

        System.out.println("Print Iteration 4");
        PQL.restraverse();
        PQL.printfirst();
        PQL.mtraverse("l");
        PQL.mtraverse("p");
        PQL.mtraverse("r");
        PQL.mtraverse("l");

        System.out.println("Print Iteration 5");
        PQL.restraverse();
        PQL.printfirst();
        PQL.mtraverse("l");
        PQL.mtraverse("l");
        PQL.mtraverse("l");

        System.out.println("Return max");
        System.out.println(PQL.delmax());
        System.out.println("Next max");
        System.out.println(PQL.delmax());
        System.out.println(PQL.delmax());
        System.out.println(PQL.delmax());

        PQL.insert(6000);
        System.out.println("Print Iteration 6");
        PQL.restraverse();
        PQL.printfirst();
        PQL.mtraverse("l");
        PQL.mtraverse("p");
        PQL.mtraverse("r");
    }
}
