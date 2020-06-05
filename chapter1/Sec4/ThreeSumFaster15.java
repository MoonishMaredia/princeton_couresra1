import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class ThreeSumFaster15 {

    public static int count(int[] arr) {

        Arrays.sort(arr);

        int i = 0;
        int j = arr.length - 1;
        int cnt = 0;

        while (i < j) {
            if (-arr[i] > arr[j]) {
                i++;
            } else if (-arr[i] < arr[j]) {
                j--;
            } else {
                i++;
                j--;
                cnt++;
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        int[] a = In.readInts(args[0]);
        StdOut.println(count(a));
    }
}
