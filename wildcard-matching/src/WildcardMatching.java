/**
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * https://leetcode-cn.com/problems/wildcard-matching/
 */

public class WildcardMatching {

    // 类似 最长公共子串，最长公共子序列，编辑距离 等 求 2 个字符串(或数组)之间的某种关系的题目，一般来说都是有动态规划的解法的。
    /*
    如果 p[i - 1] == s[j - 1] 或 p[i - 1] == '?'，表示当前的字符串是匹配的，dp[i][j] 可以从 dp[i - 1][j - 1] 转移而来。
    如果 p[i - 1] == '*'，这个位置可以匹配 0 到 若干个字符。那么 dp[i][j] 可以从 dp[i - 1][j]（表示当前星号没有匹配字符），或dp[i][j - 1] 转移而来（表示当前星号匹配了当前的位置的字符）。
    因为只要任意一种匹配即可，所以这里是逻辑或的关系。
     */
    public boolean isMatch2(String s, String p) {
        int len1 = p.length(), len2 = s.length();
        boolean[][] dp = new boolean[len1 + 1] [len2 + 1];
        dp[0][0] = true; // 最终状态1
        for (int i = 1; i <= len1; i++) {
            if (p.charAt(i - 1) != '*') {
                break;
            }
            dp[i][0] = true;  // 最终状态2
        }

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {   // 状态转移
                if (p.charAt(i - 1) == s.charAt(j - 1) || p.charAt(i - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(i - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] | dp[i][j - 1];
                }
            }
        }
        return dp[len1][len2];
    }

    // 因为有 “*”的存在，可以使用贪婪算法的思想
    public static boolean isMatch(String s, String p) {
        int sRight = s.length(), pRight = p.length();
        // 从左往右找到第一个“*”
        while (sRight > 0 && pRight > 0 && p.charAt(pRight - 1) != '*') {
            if (charMatch(s.charAt(sRight - 1), p.charAt(pRight - 1))) {
                sRight--;
                pRight--;
            } else {
                return false;
            }
        }

        if (pRight == 0) {
            return sRight == 0;
        }

        int sIndex = 0, pIndex = 0;
        int sRecord = -1, pRecord = -1;

        while (sIndex < sRight && pIndex < pRight) {
            if (p.charAt(pIndex) == '*') {
                ++pIndex;
                sRecord = sIndex;
                pRecord = pIndex;
            } else if (charMatch(s.charAt(sIndex), p.charAt(pIndex))) {
                ++sIndex;
                ++pIndex;
            } else if (sRecord != -1 && sRecord + 1 < sRight) {
                ++sRecord;
                sIndex = sRecord;
                pIndex = pRecord;
            } else {
                return false;
            }
        }

        for (int i = pIndex; i < pRight; ++i) {
            if (p.charAt(i) != '*') {
                return false;
            }
        }
        return true;
    }

    private static boolean charMatch(char u, char v) {
        return u == v || v == '?';
    }

    public static void main(String[] asd) {
        System.out.println(isMatch("asdasd", "x**"));
    }
}
