public class BitRep {

    public static String bitcalc(int k) {
        int exp = 0;
        while (true) {
            if (k == Math.pow(2, exp)) {
                break;
            } else if (k > Math.pow(2, exp)) {
                exp++;
            } else if (k == 0) {
                break;
            } else {
                exp--;
                break;
            }
        }

        String res = "";
        while (exp >= 0) {
            if (Math.pow(2, exp) <= k) {
                res += '1';
                k -= Math.pow(2, exp);
                exp--;
            } else {
                res += '0';
                exp--;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(bitcalc(0));
    }

}
