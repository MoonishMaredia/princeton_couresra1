import edu.princeton.cs.algs4.StdIn;

import java.util.Iterator;

public class Permutation {

    public static void main(String[] args) {

        int k = Integer.parseInt(args[0]);
        RandomizedQueue<String> rque = new RandomizedQueue<>();
        String str;

        while (!StdIn.isEmpty()) {
            str = StdIn.readString();
            rque.enqueue(str);
        }

        Iterator<String> it = rque.iterator();

        for (int i = 0; i < k; i++) {
            System.out.println(it.next());
        }

    }
}
