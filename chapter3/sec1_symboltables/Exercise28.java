//3.1.28 Ordered insertions. Modify BinarySearchST so that inserting a key that is larger than all keys in the table takes constant time (so that building a table by calling put()
//        for keys that are in order takes linear time).


import java.util.ArrayList;
import java.util.List;

public class Exercise28<Key extends Comparable<Key>, Value> {

    private Key[] keys;
    private Value[] vals;
    private int size = 0;

    public Exercise28() {
        keys = (Key[]) new Comparable[2];
        vals = (Value[]) new Object[2];
    }

    public void resize(int newL) {

        Key[] temp1 = (Key[]) new Comparable[newL];
        Value[] temp2 = (Value[]) new Object[newL];

        for (int i = 0; i < size; i++) {
            temp1[i] = keys[i];
            temp2[i] = vals[i];
        }

        keys = temp1;
        vals = temp2;

        temp1 = null;
        temp2 = null;

    }

    public void put(Key key, Value val) {

//        System.out.println("Inputting a new value with starting index: " + 0 + " ending index: " + (size - 1));
//        System.out.println("Current array looks like this: " + Arrays.toString(keys));


        if (key.compareTo(keys[size - 1]) >= 0) {
            keys[size] = key;
            vals[size] = val;
            size++;

            if (keys.length / 2 == size) {
                resize(keys.length * 2);
            }

            return;
        }

        int i = rank(key, 0, size - 1);
//        System.out.println("inserting at index: " + i);

        if (i < size && (key.compareTo(keys[i]) == 0)) {
            vals[i] = val;
            return;
        }

        for (int j = size; j > i; j--) {
            keys[j] = keys[j - 1];
            vals[j] = vals[j - 1];
        }

        keys[i] = key;
        vals[i] = val;
        size++;

        if (keys.length / 2 == size) {
            resize(keys.length * 2);
        }
        return;
    }

    public int rank(Key key, int lo, int hi) {
        //recursive
        if (lo > hi) return lo;
        int mid = lo + (hi - lo) / 2;
        int cmp = key.compareTo(keys[mid]);

        if (cmp < 0)
            return rank(key, lo, mid - 1);
        else if (cmp > 0)
            return rank(key, mid + 1, hi);
        else
            return mid;
    }

    public int rank(Key key) {
        //iterative
        int lo = 0, hi = size - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(keys[mid]);
            if (cmp < 0) hi = mid - 1;
            else if (cmp > 0) lo = mid + 1;
            else return mid;
        }
        return lo;
    }

    public Value get(Key key) {

        int i = rank(key, 0, size - 1);
        if (i < size && (key.compareTo(keys[i]) == 0)) {
            return vals[i];
        }
        return null;
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public Iterable<Key> getkeys() {
        List<Key> arr = new ArrayList<Key>();
        for (int i = 0; i < size; i++) {
            arr.add(keys[i]);
        }
        return arr;
    }

    public static void main(String[] args) {
        //do nothing
    }
}
