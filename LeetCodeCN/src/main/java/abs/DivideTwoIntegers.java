package abs;

import org.junit.Test;

// https://leetcode.cn/problems/divide-two-integers/description/
public class DivideTwoIntegers {

    int MIN = Integer.MIN_VALUE, MAX = Integer.MAX_VALUE;
    int LIMIT = -1073741824; // MIN 的一半

    // 解法1.二分+倍增
    public int divide1(int dividend, int divisor) {
        if (dividend == MIN && divisor == -1) return MAX;
        boolean flag = (dividend <= 0 && divisor > 0) || (dividend >= 0 && divisor < 0);
        // 负数的绝对值可以是2^31
        if (dividend > 0) dividend = -dividend;
        if (divisor > 0) divisor = -divisor;
        int ans = 0;
        while (dividend <= divisor) {
            int sum = divisor;
            int n = -1;
            while (sum >= LIMIT && n >= LIMIT && sum >= dividend - sum){
                sum += sum; n += n;
            }
            dividend -= sum;
            ans += n;
        }
        return flag? ans: -ans;
    }

    // 快速乘法
    public static int divide2(int dividend, int divisor) {
        long d1 = Math.abs(((long)dividend));
        long d2 = Math.abs(((long)divisor));
        boolean isNeg = (dividend ^ divisor) < 0;
        long l = 1, r = d1;
        long ans = 0;
        while(l <= r) {
            long mid = l + ((r - l) >> 1);
            if(multiply(mid, d2) <= d1) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        if(!isNeg && ans > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        return (int) (isNeg ? -ans : ans);
    }

    public static long multiply(long a, long b) {
        long ans = 0;
        while(b > 0) {
            if((b & 1) == 1) {
                ans += a;
            }
            a += a;
            b >>= 1;
        }
        return ans;
    }

    // 解法2.转成字符串列竖式
//    public int divide2(int dividend, int divisor) {
//
//    }

    public int divide(int dividend, int divisor) {
        if (dividend == 0) return 0;
        boolean fuhao;
        fuhao = (dividend <= 0 || divisor >= 0) && (dividend >= 0 || divisor <= 0);
        dividend = Math.abs(dividend) <0 ? Integer.MAX_VALUE:Math.abs(dividend);
        divisor = Math.abs(divisor);
        int ans = 0;
        while (dividend >= 0) {
            dividend -= divisor;
            ans++;
        }
        return fuhao ? ans - 1 : -(ans - 1);
    }

    @Test
    public void test() {
        System.out.println(divide(-2147483648, -1));
        int a = -2147483648;
        System.out.println(-a); // -2147483648
    }
}
