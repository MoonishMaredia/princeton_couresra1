import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class EvaluatePostfixProb11 {

    public static void main(String[] args) {

//      MyStackImplementation<String> ops = new MyStackImplementation<String>();
        MyStackImplementation<Double> vals = new MyStackImplementation<Double>();

        while (!StdIn.isEmpty()) {
            double x = 0.0;
            String s = StdIn.readString();
            StdOut.println(s);
            if (s.equals("*") || s.equals("+") || s.equals("-") || s.equals("/")) {
                if (s.equals("*"))
                    x = vals.pop() * vals.pop();
                else if (s.equals("+"))
                    x = vals.pop() + vals.pop();
                else if (s.equals("-"))
                    x = vals.pop() - vals.pop();
                else if (s.equals("/"))
                    x = (1 / vals.pop()) * vals.pop();
                vals.push(x);
                StdOut.println(x);
            } else {
                vals.push(Double.parseDouble(s));
            }
        }
        StdOut.println(vals.pop());
    }
}
