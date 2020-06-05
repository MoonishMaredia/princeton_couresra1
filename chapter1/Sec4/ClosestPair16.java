import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

public class ClosestPair16 {

    public static double[] closest(double arr[]) {

        Arrays.sort(arr);
        double[] result = new double[2];
        double min = Double.POSITIVE_INFINITY;

        int N = arr.length;

        for (int i = 0; i < N - 1; i++) {
            double tmp = Math.abs(arr[i] - arr[i + 1]);

            if (tmp < min) {
                min = tmp;
                result[0] = arr[i];
                result[1] = arr[i + 1];
            }
        }
        return result;
    }

    public static void genrandom() {
        for (int i = 0; i < 1000; i++)
            System.out.println(StdRandom.uniform(-1000, 1000) * 1.000 / 100);
    }

    public static void main(String[] args) {
        double[] a = In.readDoubles(args[0]);
        System.out.println(Arrays.toString(closest(a)));
//        genrandom();

    }
}
