import java.util.Arrays;

// https://leetcode.cn/problems/coin-change/
public class CoinChange {

    // f(amount) = min(f(amount-coins[0]) ... f(amount-coins(len-1))) + 1
    public int coinChange(int[] coins, int amount) {
        int len = coins.length;
        if (amount == 0) return 0;
//        if (len == 1) return amount == coins[0] ? 1 : -1;

        int[] f = new int[amount + 1];
        Arrays.fill(f, amount + 1);
        f[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    f[i] = Math.min(f[i], f[i - coin] + 1);
                }
            }
        }
        return f[amount] > amount ? -1 : f[amount];
    }
}
