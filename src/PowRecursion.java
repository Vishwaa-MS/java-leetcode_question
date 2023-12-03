public class PowRecursion {
    public static double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        if (n < 0) {
            if (n == Integer.MIN_VALUE) {
                return 1 / myPow(x, Integer.MAX_VALUE) * x;
            }
            return 1 / myPow(x, -n);
        }
        double halfPow = myPow(x, n / 2);
        return n % 2 == 0 ? halfPow * halfPow : halfPow * halfPow * x;
    }

    public static void main(String[] args) {
        double ans = myPow(2.00000, 10);
        System.out.println(ans);
    }

}
