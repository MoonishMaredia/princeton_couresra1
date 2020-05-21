import java.util.Arrays;

public class Matrix {

    public Matrix() {
        //no constructor needed
    }

    static double dot(double[] x, double[] y) {
        if (x.length != y.length) {
            throw new IllegalArgumentException("Arrays must be of the same size");
        }

        int xlen = x.length;
        double sum = 0;

        for (int i = 0; i < xlen; i++) {
            sum += (x[i] * y[i]);
        }
        return sum;
    }

    static double[][] mult(double[][] a, double[][] b) {
        int rows = a.length;
        int mlen = a[0].length;
        int cols = b[0].length;

        double[][] result = new double[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                for (int k = 0; k < mlen; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                }
            }
        }

        return result;
    }

    static double[] mult(double[][] a, double[] b) {
        int rows = a.length;
        int mlen = a[0].length;

        double[] result = new double[rows];

        for (int i = 0; i < rows; i++) {
            for (int k = 0; k < mlen; k++) {
                result[i] += a[i][k] * b[k];
            }
        }
        return result;
    }


    static double[] mult(double[] b, double[][] a) {
        int rows = b.length;
        int mlen = a[0].length;

        double[] result = new double[rows];

        for (int i = 0; i < rows; i++) {
            for (int k = 0; k < mlen; k++) {
                result[i] += b[k] * a[i][k];
            }
        }
        return result;
    }


    public static double[][] transpose(double[][] arr) {

        int cols = arr.length;
        int maxlen = 0;
        for (int i = 0; i < cols; i++) {
            if (arr[i].length > maxlen)
                maxlen = arr[i].length;
        }

        double[][] newarr = new double[maxlen][cols];

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
        return newarr;
    }


    public static void main(String[] args) {

//        double[] x = {1, 2, 3, 4};
//        double[] y = {5, 6, 7, 8};
//
//        System.out.println(Matrix.dot(x, y));
//

//        double[][] x = {{12, 7, 3}, {4, 5, 6}, {7, 8, 9}};
//        double[][] y = {{5, 8, 1}, {6, 7, 3}, {4, 5, 9}};
//        System.out.println(Arrays.deepToString(Matrix.mult(x, y)));
//        System.out.println(Arrays.deepToString(Matrix.transpose(x)));

        double[][] a = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        double[][] b = {{10}, {11}, {12}};

        System.out.println(Arrays.deepToString(Matrix.mult(a, b)));
    }
}



