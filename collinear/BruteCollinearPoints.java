import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Arrays;

public class BruteCollinearPoints {

    private final LineSegment[] linesegments;

    public BruteCollinearPoints(Point[] points) {
        // finds all line segments containing 4 points

        checkNull(points);
        Point[] sortedpoints = points.clone();
        Arrays.sort(sortedpoints);
        checkDuplicate(sortedpoints);
        ArrayList<LineSegment> segmentsList = new ArrayList<LineSegment>();

        final int N = sortedpoints.length;

        for (int a = 0; a < N - 3; a++) {
            Point ptA = sortedpoints[a];

            for (int b = a + 1; b < N - 2; b++) {
                Point ptB = sortedpoints[b];
                double slopeAB = ptA.slopeTo(ptB);

                for (int c = b + 1; c < N - 1; c++) {
                    Point ptC = sortedpoints[c];
                    double slopeAC = ptA.slopeTo(ptC);

                    for (int d = c + 1; d < N; d++) {
                        Point ptD = sortedpoints[d];
                        double slopeAD = ptA.slopeTo(ptD);

                        if ((Double.compare(slopeAB, slopeAC) == 0) && (Double.compare(slopeAB, slopeAD) == 0)) {
                            LineSegment temp = new LineSegment(ptA, ptD);
                            if (!segmentsList.contains(temp)) {
                                segmentsList.add(temp);
                            }
                        }
                    }
                }
            }
        }
        linesegments = segmentsList.toArray(new LineSegment[segmentsList.size()]);
    }

    public int numberOfSegments() {
        // the number of line segments
        return linesegments.length;
    }

    public LineSegment[] segments() {
        // the line segments
        return linesegments.clone();
    }

    private void checkNull(Point[] points) {
        if (points == null) {
            throw new NullPointerException("The array \"Points\" is null.");
        }

        for (Point p : points) {
            if ((p == null)) {
                throw new NullPointerException("The array \"Points\" contains null element");
            }
        }
    }

    private void checkDuplicate(Point[] points) {
        for (int i = 0; i < points.length - 1; i++) {
            if (points[i].compareTo(points[i + 1]) == 0) {
                throw new NullPointerException("The array contains a duplicate point");
            }
        }
    }

    public static void main(String[] args) {
        // read the n points from a file
        In in = new In(args[0]);
        int n = in.readInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x, y);
        }

        // draw the points
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        for (Point p : points) {
            p.draw();
        }
        StdDraw.show();

        // print and draw the line segments
        BruteCollinearPoints collinear = new BruteCollinearPoints(points);
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show();
    }
}
