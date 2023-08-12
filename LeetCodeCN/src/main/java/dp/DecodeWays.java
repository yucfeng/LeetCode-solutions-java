package dp;

import org.junit.Test;

import java.net.InetAddress;

/*
f[i]=f[i−1],1⩽a≤9
f[i]=f[i−2],10⩽b⩽26
f[i]=f[i−1]+f[i−2],1⩽a≤9,10⩽b⩽26
 */
public class DecodeWays {

    int ans = 0;
    boolean valid = true;

    public int numDecodings(String s) {
        String s1 = " " + s;
        char[] cs = s1.toCharArray();
        int[] dp = new int[s1.length()];
        dp[0] = 1;
        for (int i = 1; i < s1.length(); i++) {
            int a = cs[i] - '0';
            int b = (cs[i - 1] - '0') * 10 + (cs[i] - '0');
            if (a >= 1 && a <= 9) dp[i] = dp[i - 1];
            if (b >= 10 && b <= 26) dp[i] += dp[i - 2];
        }
        return dp[s1.length() - 1];
    }

    public void dp(String s) {
        if (!valid || s.isEmpty()) return;
        if (s.length() == 1 && !s.equals("0")) {
            ans++;
        }
        if (s.length() == 2) {
            ans += isValid(s);
        }

    }

    public int isValid(String subStr) {
        if (subStr.startsWith("0")) {
            valid = false;
            return 0;
        } else {
            int num = Integer.parseInt(subStr);
            if (num <= 26 && num > 0) {
                return subStr.contains("0") ? 1 : 2;
            }
        }
        valid = false;
        return 0;
    }

    @Test
    public void test() {
//        System.out.println(numDecodings("226"));
        float a = 6.6f;
        float b = 1.3f;
        System.out.println(a +b);
    }
}
