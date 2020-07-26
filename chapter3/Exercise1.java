//3.1.1 Write a client that creates a symbol table mapping letter grades to numerical
//        scores, as in the table below, then reads from standard input a list of letter grades and
//        computes and prints the GPA (the average of the numbers corresponding to the grades).
//        A+    A     A-  B+    B    B-   C+    C   C-   D    F
//        4.33 4.00 3.67 3.33 3.00 2.67 2.33 2.00 1.67 1.00 0.00

import edu.princeton.cs.algs4.In;

public class Exercise1<Key extends Comparable<Key>, Value> {

    private Key[] letters;
    private Value[] gpas;
    private int size = 0;

    public Exercise1() {
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

    public static void main(String[] args) {
        Exercise1<String, Double> test = new Exercise1<String, Double>();

        test.put("Aplus", 4.33);
        test.put("A", 4.00);
        test.put("Aminus", 3.67);
        test.put("Bplus", 3.33);
        test.put("B", 3.00);
        test.put("Bminus", 2.67);
        test.put("Cplus", 2.33);
        test.put("C", 2.00);
        test.put("Cminus", 1.67);
        test.put("D", 1.00);
        test.put("F", 0.00);

//        System.out.println("==================Final Order==================");
//        System.out.println(Arrays.toString(test.letters));
//        System.out.println(Arrays.toString(test.gpas));
//
//        System.out.println("==================Correct Order==================");
//
//        String[] arr = {"Aplus", "A", "Aminus", "B", "Bplus", "Bminus", "C", "Cplus", "Cminus", "D", "F"};
//        Arrays.sort(arr);
//
//        System.out.println(Arrays.toString(arr));

        System.out.println("--------------Getting Value------------------");

        System.out.println(test.get("A"));
        System.out.println(test.get("Aminus"));
        System.out.println(test.get("Aplus"));
        System.out.println(test.get("B"));
        System.out.println(test.get("Bplus"));
        System.out.println(test.get("C"));
        System.out.println(test.get("D"));
        System.out.println(test.get("F"));

        In in = new In(args[0]);
        int n = in.readInt();
        double tot = 0.0;

        for (int i = 0; i < n; i++) {
            String grade = in.readString();
            tot += test.get(grade);
        }

        System.out.println("The average grade for the class is: " + tot / n);

    }
}
