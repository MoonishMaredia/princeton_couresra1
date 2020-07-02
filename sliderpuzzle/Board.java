import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdRandom;

public class Board {

    private final int[][] board;
    private final int[] flat;
    private int blankrow;
    private int blankcol;
    private int blankflat;


    public Board(int[][] tiles) {
        // create a board from an n-by-n array of tiles,
        // where tiles[row][col] = tile at (row, col)

        board = tiles;
        int n = tiles.length;
        int fsz = (n * n);
        flat = new int[fsz];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                flat[idx] = board[i][j];
                idx++;
                if (board[i][j] == 0) {
                    blankrow = i;
                    blankcol = j;
                    blankflat = idx - 1;
                }
            }
        }
    }

    public String toString() {
        // string representation of this board

        int sz = board.length;
        String res = "";
        res += Integer.toString(sz);

        for (int i = 0; i < sz; i++) {
            res += "\r\n";
            for (int j = 0; j < sz; j++) {
                res += (Integer.toString(board[i][j]) + " ");
            }
        }
        return res;
    }


    public int dimension() {
        // board dimension n
        return board.length;
    }

    public void getblankposition() {
        // get the x,y position for the blank on the board
        System.out.println("Blank is at (" + blankrow + " ," + blankcol + ")");
    }


    public int hamming() {
        // number of tiles out of place
        int sz = board.length;
        int sum = 0;
        int pos = 1;
        for (int i = 0; i < sz; i++) {
            for (int j = 0; j < sz; j++) {
                if (pos < sz * sz) {
                    if (board[i][j] != pos)
                        sum += 1;
                    pos += 1;
                }
            }
        }
        return sum;
    }


    public int manhattan() {
        // sum of Manhattan distances between tiles and goal
        int sum = 0;
        int sz = board.length;
        for (int i = 0; i < sz; i++) {
            for (int j = 0; j < sz; j++) {
                if (board[i][j] == 0)
                    continue;
                else {
                    sum += manhdist(board[i][j], i, j, sz);
                }
            }
        }
        return sum;
    }

    public int manhdist(int elem, int currow, int curcol, int sz) {
        // helper function to calculate the manhattan distances
        int frow = (elem - 1) / sz;
        int fcol = (elem - 1) % sz;
        int res = Math.abs(currow - frow) + Math.abs(curcol - fcol);

        return res;
    }

    public int[][] createGoal(int sz) {
        // creates a goal board based on the size of the board (nxn)
        int[][] glarr = new int[sz][sz];
        int pos = 1;
        for (int i = 0; i < sz; i++)
            for (int j = 0; j < sz; j++) {
                glarr[i][j] = pos;
                pos++;
            }
        glarr[sz - 1][sz - 1] = 0;
        return glarr;
    }


    public boolean isGoal() {
        // is this board the goal board?
        return this.equals(new Board(createGoal(board.length)));
    }


    public boolean equals(Object y) {
        // does this board equal y?

        if (y == this) return true;
        if (y == null) return false;

        if (!this.getClass().equals(y.getClass())) {
            return false;
        }

        Board y2 = (Board) y;

        int sz = board.length;
        if (sz != y2.board.length)
            return false;

        for (int i = 0; i < sz; i++) {
            for (int j = 0; j < sz; j++) {
                if (board[i][j] != y2.board[i][j])
                    return false;
            }
        }
        return true;
    }

    public void swap(int[][] dblarr, int currow, int curcol, int newrow, int newcol) {
        // swaps elements in a nxn array given (cur row, cur col) -> (new row, new col)

        int temp = dblarr[currow][curcol];
        dblarr[currow][curcol] = dblarr[newrow][newcol];
        dblarr[newrow][newcol] = temp;
    }

    public int[][] copy() {
        // creates a new copy of the existing board

        int n = board.length;
        int[][] ret = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ret[i][j] = board[i][j];
            }
        }
        return ret;
    }


    public Iterable<Board> neighbors() {
        // all neighboring boards

        Stack<Board> itStack = new Stack<>();

        //up
        if (blankrow != 0) {
            int[][] up = copy();
            swap(up, blankrow, blankcol, blankrow - 1, blankcol);
            Board up1 = new Board(up);
            itStack.push(up1);
        }

        //down
        if (blankrow != board.length - 1) {
            int[][] down = copy();
            swap(down, blankrow, blankcol, blankrow + 1, blankcol);
            Board down1 = new Board(down);
            itStack.push(down1);
        }

        //left
        if (blankcol != 0) {
            int[][] left = copy();
            swap(left, blankrow, blankcol, blankrow, blankcol - 1);
            Board left1 = new Board(left);
            itStack.push(left1);
        }

        //right
        if (blankcol != board.length - 1) {
            int[][] right = copy();
            swap(right, blankrow, blankcol, blankrow, blankcol + 1);
            Board right1 = new Board(right);
            itStack.push(right1);
        }

        return itStack;
    }

    //

    public Board twin() {
        // a board that is obtained by exchanging any pair of tiles

        int[][] randarr = copy();
        int sz = board.length;

        int j = 0;
        while (true) {
            j += StdRandom.uniform(0, flat.length);
            if (j != blankflat)
                break;
            j -= j;
        }

        int rand1 = j;

        int k = 0;
        while (true) {
            k += StdRandom.uniform(0, flat.length);
            if ((k != rand1) && (k != blankflat)) {
                break;
            }
            k -= k;
        }

        int rand2 = k;

        swap(randarr, rand1 / sz, (rand1 % sz), rand2 / sz, (rand2 % sz));
        Board twinres = new Board(randarr);

        return twinres;
    }


    public static void main(String[] args) {

//        int[][] test = new int[4][4];
//        test[0][0] = 1;
//        test[0][1] = 2;
//        test[0][2] = 3;
//        test[0][3] = 4;
//        test[1][0] = 5;
//        test[1][1] = 6;
//        test[1][2] = 7;
//        test[1][3] = 8;
//        test[2][0] = 9;
//        test[2][1] = 10;
//        test[2][2] = 11;
//        test[2][3] = 12;
//        test[3][0] = 13;
//        test[3][1] = 14;
//        test[3][2] = 15;
//        test[3][3] = 0;

        int[][] test = new int[3][3];
        test[0][0] = 0;
        test[0][1] = 4;
        test[0][2] = 2;
        test[1][0] = 3;
        test[1][1] = 5;
        test[1][2] = 7;
        test[2][0] = 6;
        test[2][1] = 8;
        test[2][2] = 1;

        Board puzzle = new Board(test);

        System.out.println("======= Print the Puzzle =======");
        System.out.println(puzzle.toString());

        System.out.println("======= Print the Hamming Distance =======");
        System.out.println(puzzle.hamming());

        System.out.println("======= Print the Manhattan Distance =======");
        System.out.println(puzzle.manhattan());

        System.out.println("======= Is this is the goal board? =======");
        System.out.println(puzzle.isGoal());
        Board goal = new Board(puzzle.createGoal(test.length));
        System.out.println(goal.toString());

        System.out.println("======= Are these goal boards equal? =======");
        Board puzzle2 = new Board(test);
        System.out.println(puzzle.equals(puzzle2));

        System.out.println("======= Boards Iterator Object =======");
        Iterable<Board> it = puzzle.neighbors();
        puzzle.getblankposition();
        for (Board s : it)
            System.out.println(s.toString());

        System.out.println("======= Twin Object =======");
        Board twin = puzzle.twin();
        System.out.println(twin.toString());
    }
}
