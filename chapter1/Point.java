public class Point {

    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getdist(Point that) {
        return Math.sqrt(Math.pow((this.x - that.x), 2) + Math.pow((this.y - that.y), 2));
    }

    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);
        Point[] rand_arr = new Point[n];

        for (int i = 0; i < n; i++) {
            double x = (double) StdRandom.uniform(0, 1000) / 1000;
            double y = (double) StdRandom.uniform(0, 1000) / 1000;
            rand_arr[i] = new Point(x, y);
        }

        double max_dist = Double.NEGATIVE_INFINITY;
        double dist = 0.000;

        for (Point a : rand_arr) {
            System.out.println(a.x + "," + a.y);
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                dist = (rand_arr[i]).getdist(rand_arr[j]);
                if (dist > max_dist) {
                    max_dist = dist;
                }
            }
        }

        System.out.println(max_dist);
    }
}
