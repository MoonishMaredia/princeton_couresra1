import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

import static java.lang.System.out;

public class Exercises {

    public Exercises() {
        // no constructor class
    }

//    1.1.1 Give the value of each of the following expressions:
//            a. ( 0 + 15 ) / 2
//    b. 2.0e-6 * 100000000.1
//    c. true && false || true && true

    public void sec1ex1() {
        // Exercise 1.1.1
        System.out.println((0 + 15) / 2);
        System.out.println((2.0e-6) * 100000000.1);
        System.out.println((true && false) || (true && true));
    }

//    1.1.2 Give the type and value of each of the following expressions:
//            a. (1 + 2.236)/2
//    b. 1 + 2 + 3 + 4.0
//    c. 4.1 >= 4
//    d. 1 + 2 + "3"

    public void sec1ex2() {
        // Exercise 1.1.2
        System.out.println((1 + 2.236) / 2);
        System.out.println(1 + 2 + 3 + 4.0);
        System.out.println(4.1 >= 4);
        System.out.println(1 + 2 + "3");
    }

//    1.1.3 Write a program that takes three integer command-line arguments and prints
//    equal if all three are equal, and not equal otherwise

    public void sec1ex3(int a, int b, int c) {
        if ((a == b) & (b == c)) {
            System.out.println("All Equal");
        } else {
            System.out.println("Not Equal");
        }
    }

//    1.1.5 Write a code fragment that prints true if the double variables x and y are both
//    strictly between 0 and 1 and false otherwise.

    public void sec1ex5(double a, double b) {
        if ((a >= 0 && a <= 1) && (b >= 0 && b <= 1)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

//    1.1.6 What does the following program print?
//    int f = 0;
//    int g = 1;
//for (int i = 0; i <= 15; i++)
//    {
//        StdOut.println(f);
//        f = f + g;
//        g = f - g;
//    }

    public void sec1ex6() {
        int f = 0;
        int g = 1;
        for (int i = 0; i <= 15; i++) {
            System.out.println(f);
            f = f + g;
            g = f - g;
        }
    }

//    1.1.7 Give the value printed by each of the following code fragments:
//    a. double t = 9.0;
// while (Math.abs(t - 9.0/t) > .001)
//    t = (9.0/t + t) / 2.0;
// StdOut.printf("%.5f\n", t);
//    b. int sum = 0;
// for (int i = 1; i < 1000; i++)
//            for (int j = 0; j < i; j++)
//    sum++;
// StdOut.println(sum);
//    c. int sum = 0;
// for (int i = 1; i < 1000; i *= 2)
//            for (int j = 0; j < N; j++)
//    sum++;
// StdOut.println(sum);

    public void sec1ex7() {
        int sum = 0;
        for (int i = 1; i < 1000; i++)
            for (int j = 0; j < i; j++)
                sum++;
        System.out.println(sum);
    }

//    1.1.8 What do each of the following print?
//            a. System.out.println('b');
//b. System.out.println('b' + 'c');
//c. System.out.println((char) ('a' + 4));
//    Explain each outcome.

    public void sec1ex8() {
        //Expect to return the character 'b' when printed
        System.out.println('b');
        //Returns an integer because these two elements are chars
        //Adding two chars results in an integer
        //Where each char refers to an int that specifies an unsigned integer
        System.out.println('b' + 'c');
        //Adds 4 to the integer specifying 'a' and converts into a charcter
        System.out.println((char) ('a' + 4));
    }

//    1.1.13 Write a code fragment to print the transposition (rows and columns changed)
//    of a two-dimensional array with M rows and N columns.

    public void sec1ex13(int[][] arr) {

        int cols = arr.length;
        int maxlen = 0;
        for (int i = 0; i < cols; i++) {
            if (arr[i].length > maxlen)
                maxlen = arr[i].length;
        }

        int[][] newarr = new int[maxlen][cols];

        for (int i = 0; i < cols; i++) {
            int j = 0;
            while (j < maxlen) {
                try {
                    newarr[j][i] = arr[i][j];
                } catch (ArrayIndexOutOfBoundsException e) {
                    newarr[j][i] = 999999999;
                }
                j++;
            }
        }
        System.out.println(Arrays.deepToString(newarr));
    }

//    1.1.21 Write a program that reads in lines from standard input with each line containing a name and two integers and then uses printf() to print a table with a column of
//    the names, the integers, and the result of dividing the first by the second, accurate to
//    three decimal places. You could use a program like this to tabulate batting averages for
//    baseball players or grades for students.

    public void sec1ex21(String a, int b, int c) {
        float avg = (float) b / c;
        StdOut.printf(a + " " + b + " " + c + " " + "%.4f\n", avg);
    }

    public static void main(String[] args) {

        Exercises test = new Exercises();

//        test.sec1ex1();
//        test.sec1ex2();
//        test.sec1ex8();


//        int x = Integer.parseInt(args[0]);
//        int y = Integer.parseInt(args[1]);
//        int z = Integer.parseInt(args[2]);
//        test.sec1ex3(x, y, z);
//
//        double v = Double.parseDouble(args[0]);
//        double w = Double.parseDouble(args[1]);
//        System.out.println("Exercise 5");
//
//        test.sec1ex5(v, w);
//
//        test.sec1ex6();
//        test.sec1ex7();
//        test.sec1ex8();

//        int[][] testarr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//        System.out.println(Arrays.deepToString(testarr));
//        test.sec1ex13(testarr);


//        In in = new In(args[0]);
//        int n = in.readInt();
//
//        for (int i = 0; i < n; i++) {
//            String a = in.readString();
//            int b = in.readInt();
//            int c = in.readInt();
//            test.sec1ex21(a, b, c);
//        }

    }
}
