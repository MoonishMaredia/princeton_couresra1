import edu.princeton.cs.algs4.StdDraw;

import java.util.Comparator;


public class Point implements Comparable<Point> {

    private final int x;     // x-coordinate of this point
    private final int y;     // y-coordinate of this point

    public Point(int x, int y) {
        // constructs the point (x, y)
        this.x = x;
        this.y = y;
    }

    public void draw() {
        // draws this point
        StdDraw.point(x, y);
    }

    public void drawTo(Point that) {
        // draws the line segment from this point to that point
        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    public String toString() {
        // string representation
        return "(" + x + ", " + y + ")";
    }

    public double slopeTo(Point that) {
        // the slope between this point and that point

        double slope;

        if ((this.y == that.y) && (this.x == that.x)) {
            slope = Double.NEGATIVE_INFINITY;
        } else if (this.x == that.x) {
            slope = Double.POSITIVE_INFINITY;
        } else if (this.y == that.y) {
            slope = 0.0;
        } else {
            slope = (that.y - this.y) * 1.0 / (that.x - this.x);
        }
        return slope;
    }

    public int compareTo(Point that) {
        // compare two points by y-coordinates, breaking ties by x-coordinates

        if (this.y < that.y) return -1;
        if (this.y > that.y) return 1;
        if (this.x < that.x) return -1;
        if (this.x > that.x) return 1;
        return 0;
    }

    public Comparator<Point> slopeOrder() {
        /* YOUR CODE HERE */
        return new BySlope();
    }

    private class BySlope implements Comparator<Point> {

        public int compare(Point p1, Point p2) {
            double slope1 = slopeTo(p1);
            double slope2 = slopeTo(p2);

            if (slope1 > slope2) return 1;
            if (slope1 < slope2) return -1;
            return 0;

        }
    }

    public static void main(String[] args) {
        // none needed
    }
}
