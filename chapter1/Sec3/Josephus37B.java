import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

// Copied from Rene Argento
//https://github.com/reneargento/algorithms-sedgewick-wayne/blob/master/src/chapter1/section3/Exercise37_JosephusProblem.java
//Actual implementation per request of the problem

public class Exercise37_JosephusProblem {

    private static void josephusProblem(int personOrder, int numberOfPeople) {

        Queue<Integer> queue = new Queue<>();

        for (int i = 0; i < numberOfPeople; i++) {
            queue.enqueue(i);
        }

        while (numberOfPeople > 0) {

            for (int i = 1; i < personOrder; i++) {
                queue.enqueue(queue.dequeue());
            }

            StdOut.print(queue.dequeue() + " ");

            numberOfPeople--;
        }
    }

    // Parametes example: 5 10
    public static void main(String[] args) {
        int personOrder = Integer.parseInt(args[0]);
        int numberOfPeople = Integer.parseInt(args[1]);

        StdOut.println("Order in which people are eliminated:");
        josephusProblem(personOrder, numberOfPeople);
    }

}
