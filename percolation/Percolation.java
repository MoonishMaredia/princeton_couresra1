/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private boolean[][] opened;
    private final WeightedQuickUnionUF qf;
    private final int size;
    private final int bottom;
    private final int top = 0;
    private int opensites = 0;

    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("N must greater than 0");
        }
        size = n;
        bottom = size * size + 1;
        qf = new WeightedQuickUnionUF(size * size + 2);
        opened = new boolean[size][size];
    }

    public void open(int row, int column) {


        if (row < 1 || row > size) {
            throw new IllegalArgumentException("Row is out of bounds");
        }

        if (column < 1 || column > size) {
            throw new IllegalArgumentException("Column is out of bounds");
        }

        if (isOpen(row, column)) {
            //System.out.println("Site already open");
            return;
        }
        else {
            opensites++;
        }

        opened[row - 1][column - 1] = true;

        if (row == 1) {
            qf.union(getQFindex(row, column), top);
        }

        if (row == size) {
            qf.union(getQFindex(row, column), bottom);
        }

        if (column > 1 && isOpen(row, column - 1)) {
            qf.union(getQFindex(row, column), getQFindex(row, column - 1));
        }

        if (column < size && isOpen(row, column + 1)) {
            qf.union(getQFindex(row, column), getQFindex(row, column + 1));
        }

        if (row > 1 && isOpen(row - 1, column)) {
            qf.union(getQFindex(row, column), getQFindex(row - 1, column));
        }

        if (row < size && isOpen(row + 1, column)) {
            qf.union(getQFindex(row, column), getQFindex(row + 1, column));
        }

    }

    public boolean isOpen(int row, int column) {
        return opened[row - 1][column - 1];
    }

    public int numberOfOpenSites() {
        return opensites;
    }

    public boolean isFull(int row, int column) {
        if (0 < row && row <= size && 0 < column && column <= size) {
            return qf.find(top) == qf.find(getQFindex(row, column));
        }
        else {
            throw new IndexOutOfBoundsException();
        }
    }

    private int getQFindex(int row, int column) {
        return size * (row - 1) + column;
    }

    public boolean percolates() {
        return qf.find(top) == qf.find(bottom);
    }

    public static void main(String[] args) {
        //Need a main method for processing
    }

}


