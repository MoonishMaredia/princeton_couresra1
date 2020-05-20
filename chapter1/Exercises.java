import java.util.Arrays;

import static java.lang.System.out;

public class Exercises {

    public Exercises() {
        // no constructor class
    }

    public void sec1ex1() {
        // Exercise 1.1.1
        System.out.println((0 + 15) / 2);
        System.out.println((2.0e-6) * 100000000.1);
        System.out.println((true && false) || (true && true));
    }

    public void sec1ex2() {
        // Exercise 1.1.2
        System.out.println((1 + 2.236) / 2);
        System.out.println(1 + 2 + 3 + 4.0);
        System.out.println(4.1 >= 4);
        System.out.println(1 + 2 + "3");
    }

    public void sec1ex3(int a, int b, int c) {
        if ((a == b) & (b == c)) {
            System.out.println("All Equal");
        } else {
            System.out.println("Not Equal");
        }
    }

    public void sec1ex5(double a, double b) {
        if ((a >= 0 && a <= 1) && (b >= 0 && b <= 1)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

    public void sec1ex6() {
        int f = 0;
        int g = 1;
        for (int i = 0; i <= 15; i++) {
            System.out.println(f);
            f = f + g;
            g = f - g;
        }
    }

    public void sec1ex7() {
        int sum = 0;
        for (int i = 1; i < 1000; i++)
            for (int j = 0; j < i; j++)
                sum++;
        System.out.println(sum);
    }

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

    public static void main(String[] args) {

        Exercises test = new Exercises();
        test.sec1ex1();
        test.sec1ex2();
        test.sec1ex8();

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

        int[][] testarr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(Arrays.deepToString(testarr));
        test.sec1ex13(testarr);

    }
}
