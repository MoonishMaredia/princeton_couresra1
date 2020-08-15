//3.1.26 Frequency count from a dictionary. Modify FrequencyCounter to take the
//        name of a dictionary file as its argument, count frequencies of the words from standard
//        input that are also in that file, and print two tables of the words with their frequencies,
//        one sorted by frequency, the other sorted in the order found in the dictionary file.

import edu.princeton.cs.algs4.In;

import java.util.ArrayList;

public class Exercise26 {
    public static void main(String[] args) {


        UnorderedList<String, Integer> sym1 = new UnorderedList<String, Integer>();
        SymbolAPI<Integer, ArrayList<String>> sym2 = new SymbolAPI<>();

        In in = new In(args[0]);
        int n = in.readInt();

        for (int i = 0; i < n; i++) {
            String word = in.readString();
            if (sym1.contains(word)) {
                sym1.put(word, sym1.get(word) + 1);
            } else {
                sym1.put(word, 1);
            }
        }

        Iterable<String> itr = sym1.Keys();
        for (String w : itr) {
            System.out.println(w + ": " + sym1.get(w));
        }
    }
}
