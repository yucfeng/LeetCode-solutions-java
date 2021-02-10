public class Solution {
    public double myPow(double x, int n) {
        double res = 1;
        if (n == 0) return res;
        if (n > 0) {
            for (int i = 0; i < n; i++) {
                res = res * x;
            }
        }
        if (n < 0) {
            for (int i = 0; i < -n; i++) {
                res = res * x;
            }
            res = 1 / res;
        }
        return res;
    }

    // 分而治之的思想  x^n = x^(n/2) * x^(n/2) or x^(n/2) * x^(n/2) * x
    public double myPow2(double x, int n) {
        double res = thePow(x, Math.abs(n));
        return n < 0 ? 1 / res : res;
    }

    private double thePow(double x, int n) {
        if (n == 0) return 1;
        double res = thePow(x, n / 2);
        return n % 2 == 0 ? res * res : res * res * x;
    }

}
