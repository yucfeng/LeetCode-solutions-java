import java.util.Arrays;

/*
https://leetcode.cn/problems/count-primes/
 */
public class CountPrimes {

    /*
    我们考虑这样一个事实：如果 x 是质数，那么大于 x 的 x 的倍数 2x,3x,… 一定不是质数，因此我们可以从这里入手。
我们设 isPrime[i] 表示数 i 是不是质数，如果是质数则为 1，否则为 0。
从小到大遍历每个数，如果这个数为质数，则将其所有的倍数都标记为合数（除了该质数本身），即 0，这样在运行结束的时候我们即能知道质数的个数。
     */
    public int countPrimes2(int n) {
        int[] isPrime = new int[n];
        Arrays.fill(isPrime, 1);
        int ans = 0;
        for (int i = 2; i < n; ++i) {
            if (isPrime[i] == 1) {
                ans += 1;
                if ((long) i * i < n) {
                    for (int j = i * i; j < n; j += i) {
                        isPrime[j] = 0;
                    }
                }
            }
        }
        return ans;
    }

    // i的因数范围在[2, 根号i]
    public int countPrimes(int n) {
        int ans = 0;
        for (int i=2;i<n;i++) {
            ans += isPrime(i) ? 1:0;
        }
        return ans;
    }

    private boolean isPrime(int i) {
        for (int j = 2;j*j<=i;j++) {
            if (i%j==0) return false;
        }
        return true;
    }
}
