import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FastCollinearPoints {

    private final LineSegment[] linesegments;

    public FastCollinearPoints(Point[] points) {
        // finds all line segments containing 4 or more points

        checkNull(points);
        Point[] sortedpoints = points.clone();
        Arrays.sort(sortedpoints);
        checkDuplicate(sortedpoints);

        final List<LineSegment> maxLineSegments = new LinkedList<>();

        final int N = points.length;

        for (int i = 0; i < N; i++) {

            Point orig = sortedpoints[i];
            Point[] slopes = sortedpoints.clone();
            Arrays.sort(slopes, orig.slopeOrder());

            int x = 1;
            while (x < N) {
                LinkedList<Point> candidates = new LinkedList<>();
                double slopeRef = orig.slopeTo(slopes[x]);

                do {
                    candidates.add(slopes[x++]);
                } while (x < N && (Double.compare(orig.slopeTo(slopes[x]), slopeRef) == 0));

                if (candidates.size() >= 3 && orig.compareTo(candidates.peek()) < 0) {
                    Point start = orig;
                    Point end = candidates.removeLast();
                    maxLineSegments.add(new LineSegment(start, end));
                }
            }
        }
        linesegments = maxLineSegments.toArray(new LineSegment[0]);
    }

    public int numberOfSegments() {
        // the number of line segments
        return linesegments.length;
    }

    public LineSegment[] segments() {
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
        FastCollinearPoints collinear = new FastCollinearPoints(points);
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show();
    }
}
