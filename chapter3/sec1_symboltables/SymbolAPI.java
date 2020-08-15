import java.util.ArrayList;
import java.util.List;

public class SymbolAPI<Key extends Comparable<Key>, Value> {

    private Key[] letters;
    private Value[] gpas;
    private int size = 0;

    public SymbolAPI() {
        letters = (Key[]) new Comparable[2];
        gpas = (Value[]) new Object[2];
    }

    public void resize(int newL) {

        Key[] temp1 = (Key[]) new Comparable[newL];
        Value[] temp2 = (Value[]) new Object[newL];

        for (int i = 0; i < size; i++) {
            temp1[i] = letters[i];
            temp2[i] = gpas[i];
        }

        letters = temp1;
        gpas = temp2;

        temp1 = null;
        temp2 = null;

    }

    public void put(Key key, Value val) {

//        System.out.println("Inputting a new value with starting index: " + 0 + " ending index: " + (size - 1));
//        System.out.println("Current array looks like this: " + Arrays.toString(letters));
        int i = rank(key, 0, size - 1);
//        System.out.println("inserting at index: " + i);

        if (i < size && (key.compareTo(letters[i]) == 0)) {
            gpas[i] = val;
            return;
        }

        for (int j = size; j > i; j--) {
            letters[j] = letters[j - 1];
            gpas[j] = gpas[j - 1];
        }

        letters[i] = key;
        gpas[i] = val;
        size++;

        if (letters.length / 2 == size) {
            resize(letters.length * 2);
        }
        return;
    }

    public int rank(Key key, int lo, int hi) {
        //recursive
        if (lo > hi) return lo;
        int mid = lo + (hi - lo) / 2;
        int cmp = key.compareTo(letters[mid]);

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
            int cmp = key.compareTo(letters[mid]);
            if (cmp < 0) hi = mid - 1;
            else if (cmp > 0) lo = mid + 1;
            else return mid;
        }
        return lo;
    }

    public Value get(Key key) {

        int i = rank(key, 0, size - 1);
        if (i < size && (key.compareTo(letters[i]) == 0)) {
            return gpas[i];
        }
        return null;
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public Iterable<Key> getkeys() {
        List<Key> arr = new ArrayList<Key>();
        for (int i = 0; i < size; i++) {
            arr.add(letters[i]);
        }
        return arr;
    }

    public static void main(String[] args) {
        //do nothing
    }

}
