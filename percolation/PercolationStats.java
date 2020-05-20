/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {

    private final int sims;
    private final int size;
    private static Percolation pr;
    private final double[] results;
    private static final double confidence_95 = 1.96;

    //perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {

        if (n <= 0 || trials <= 0) {
            throw new IllegalArgumentException("Trials and Size needs to be greater than 0");
        }

        sims = trials;
        results = new double[sims];
        size = n;

        for (int i = 0; i < sims; i++) {

            pr = new Percolation(size);

            while (!pr.percolates()) {

                int x = StdRandom.uniform(1, size + 1);
                int y = StdRandom.uniform(1, size + 1);
                pr.open(x, y);
            }

            int numopen = pr.numberOfOpenSites();
            double fraction = (double) numopen / (size * size);

            results[i] = fraction;
        }

    }

    //sample mean of percolation threshold
    public double mean() {
        return StdStats.mean(results);
    }

    //sample standard deviation of percolation threshold
    public double stddev() {
        return StdStats.stddev(results);
    }

    //low endpoint of 95% confidence interval
    public double confidenceLo() {
        return mean() - ((confidence_95 * stddev()) / Math.sqrt(size));
    }

    //high endpoint of 95% confidence interval
    public double confidenceHi() {
        return mean() + ((confidence_95 * stddev()) / Math.sqrt(size));
    }

    // test client (see below)
    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);

        PercolationStats stats = new PercolationStats(n, trials);
        String confidence = stats.confidenceLo() + ", " + stats.confidenceHi();
        StdOut.println("mean                    = " + stats.mean());
        StdOut.println("stddev                  = " + stats.stddev());
        StdOut.println("95% confidence interval = " + confidence);

    }

}
