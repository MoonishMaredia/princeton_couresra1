import edu.princeton.cs.algs4.In;

import java.util.Arrays;

public class BitonicSearch20 {

    public static int findmax(int[] arr, int lo, int hi) {

        int mid = lo + (hi - lo) / 2;

        if ((hi - lo) == 0) {
            return hi;
        } else if ((hi - lo) == 1) {
            if (arr[lo] > arr[hi])
                return lo;
            else
                return hi;
        }

        if ((arr[mid - 1] < arr[mid]) && (arr[mid] < arr[mid + 1])) {
//            System.out.println("Here");
//            System.out.println(lo + " " + mid + " " + hi);
            return findmax(arr, mid + 1, hi);
        } else if ((arr[mid - 1] > arr[mid]) && (arr[mid] > arr[mid + 1])) {
//            System.out.println("Or Here");
//            System.out.println(lo + " " + mid + " " + hi);
            return findmax(arr, lo, mid);
        } else {
            return mid;
        }
    }

    public static int[] reverse(int a[]) {
        int n = a.length;
        int[] b = new int[n];
        int j = n;
        for (int i = 0; i < n; i++) {
            b[j - 1] = a[i];
            j = j - 1;
        }
        return b;
    }

    public static boolean search(int[] arr, int lo, int hi, int target) {

        int index = findmax(arr, lo, hi);

        if (target == arr[index])
            return true;

        int chk1 = BinarySearch.indexOf(Arrays.copyOfRange(arr, 0, index), target);
        if (chk1 > 0)
            return true;

        int chk2 = BinarySearch.indexOf(reverse(Arrays.copyOfRange(arr, index, hi)), target);
        if (chk2 > 0)
            return true;

        return false;
    }

    public static void main(String[] args) {
        int[] a = In.readInts(args[0]);
        int target = Integer.parseInt(args[1]);
        System.out.println(search(a, 0, a.length - 1, target));
    }
}
