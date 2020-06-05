import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

public class ThreeSumFast15 {
    public static int count(int[] arr) { // Count triples that sum to 0.
        Arrays.sort(arr);
        int N = arr.length;
        int cnt = 0;

        for (int i = 0; i < N - 1; i++) {
            int j = i + 1;
            int k = N - 1;

            while (j < k) {

                int tot = (arr[i] + arr[j] + arr[k]);

                if (tot == 0) {
                    cnt++;
                    System.out.println(arr[i] + " " + arr[j] + " " + arr[k]);
                    j++;
                } else if (tot < 0) {
                    j++;
                } else if (tot > 0) {
                    k--;
                }
            }
        }
        return cnt;
    }

    public static void genrandom() {
        for (int i = 0; i < 100; i++)
            System.out.println(StdRandom.uniform(-100, 100));
    }

    public static void main(String[] args) {
        int[] a = In.readInts(args[0]);
        StdOut.println(count(a));
//        genrandom();

    }
}
