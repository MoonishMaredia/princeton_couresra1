import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Stack;

// implementation details adapted from hangingdev github

public class Solver {

    private final MinPQ<SearchNode> pq;
//    private final Board goal;

    private class SearchNode implements Comparable<SearchNode> {
        private final Board board;
        private final int moves;
        private final int priority;
        private final SearchNode previousnode;

        public SearchNode(Board board, int moves, SearchNode previousnode) {
            this.board = board;
            this.moves = moves;
            this.priority = moves + board.manhattan();
            this.previousnode = previousnode;
        }

        public int compareTo(SearchNode that) {
            return (this.priority - that.priority);
        }
    }

    // find a solution to the initial board (using the A* algorithm)
    public Solver(Board init) {

        Board initial = init;
        if (initial == null)
            throw new NullPointerException("The initial board is null. Pass an appropriate initial board");

        pq = new MinPQ<SearchNode>();
        MinPQ<SearchNode> pqTwin = new MinPQ<SearchNode>();

        SearchNode deque;
        SearchNode dequetwin;

        pq.insert(new SearchNode(initial, 0, null));
        pqTwin.insert(new SearchNode(initial.twin(), 0, null));

        while (!pq.min().board.isGoal() && !pqTwin.min().board.isGoal()) {

            deque = pq.delMin();
            dequetwin = pqTwin.delMin();

            for (Board add : deque.board.neighbors()) {
                if (deque.moves == 0)
                    pq.insert(new SearchNode(add, deque.moves + 1, deque));
                else if (!add.equals(deque.previousnode.board)) {
                    pq.insert(new SearchNode(add, deque.moves + 1, deque));
                }
            }

            for (Board add : dequetwin.board.neighbors()) {
                if (dequetwin.moves == 0)
                    pqTwin.insert(new SearchNode(add, dequetwin.moves + 1, dequetwin));
                else if (!add.equals(dequetwin.previousnode.board)) {
                    pqTwin.insert(new SearchNode(add, dequetwin.moves + 1, dequetwin));
                }
            }
        }
    }

    // is the initial board solvable? (see below)
    public boolean isSolvable() {
        if (pq.min().board.isGoal()) {
            return true;
        } else {
            return false;
        }
    }

    // min number of moves to solve initial board; -1 if unsolvable
    public int moves() {
        if (isSolvable()) {
            return pq.min().moves;
        } else {
            return -1;
        }
    }

    // sequence of boards in a shortest solution; null if unsolvable
    public Iterable<Board> solution() {
        Stack<Board> solStack = new Stack<>();
        SearchNode curr = pq.min();

        if (isSolvable()) {
            while (curr.previousnode != null) {
                solStack.push(curr.board);
                curr = curr.previousnode;
            }
            solStack.push(curr.board);
            return solStack;
        } else {
            return null;
        }
    }

    // test client (see below)
    public static void main(String[] args) {

//        int[][] test = new int[3][3];
//        test[0][0] = 0;
//        test[0][1] = 4;
//        test[0][2] = 2;
//        test[1][0] = 3;
//        test[1][1] = 5;
//        test[1][2] = 7;
//        test[2][0] = 6;
//        test[2][1] = 8;
//        test[2][2] = 1;
//
//        Board puzzle = new Board(test);
//        Solver result = new Solver(puzzle);
//        System.out.println(result.isSolvable());
//        Iterable<Board> itr = result.solution();
//        for (Board seq : itr) {
//            System.out.println(seq.toString());
//        }

    }
}
