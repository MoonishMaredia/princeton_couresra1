import java.util.Arrays;

public class QU_PathCompression12 {

    private int n;
    private int[] arr;

    public QU_PathCompression12(int n) {
        this.n = n;
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
    }

    public int find_root(int x) {
        while (x != arr[x]) {
            arr[x] = arr[arr[x]];
            x = arr[x];
        }
        return x;
    }

    public void union(int x, int y) {

        int xroot = find_root(x);
        int yroot = find_root(y);

        if (xroot == yroot)
            return;

        arr[xroot] = yroot;
        System.out.println(Arrays.toString(arr));
    }

    public boolean connected(int x, int y) {
        return (find_root(x) == find_root(y));
    }

    public static void main(String[] args) {

        QU_PathCompression12 test = new QU_PathCompression12(10);

        System.out.println("========Start Here=======");
        System.out.println(Arrays.toString(test.arr));
        System.out.println("====Union Operations=====");
        test.union(4, 3);
        test.union(3, 8);
        test.union(6, 5);
        test.union(9, 4);
        test.union(2, 1);
        test.union(8, 9);
        test.union(5, 0);
        test.union(7, 2);
        test.union(6, 1);
        test.union(1, 0);
        test.union(6, 7);
        System.out.println("====Show Connections=====");
        System.out.println(test.connected(8, 1));
        System.out.println(test.connected(6, 8));
        System.out.println(test.connected(7, 1));
        System.out.println(test.connected(4, 9));
    }
}
