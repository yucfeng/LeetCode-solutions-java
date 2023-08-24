import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.cn/problems/longest-arithmetic-subsequence-of-given-difference/
public class LongestArithmeticSubsequence {

    // f[i]=hash[prev]+1
    public int longestSubsequence1(int[] arr, int d) {
        int ans = 1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i - d, 0) + 1);
            ans = Math.max(ans, map.get(i));
        }
        return ans;
    }

    public int longestSubsequence(int[] arr, int difference) {
        int len=arr.length;
        int[][] dp = new int[len][2]; // 0代表当前位置不选，1代表当前位置选
        Map<Integer, Integer> map = new HashMap<>(); // 记录已经遍历过的数组位置<num, index>

        dp[0][1] = 1;
        dp[0][0] = 0;
        map.put(arr[0], 0);

        for (int i=1;i<len;i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);

            dp[i][1] = 1;
            int prev = arr[i] - difference;
            if (map.containsKey(prev)) {
                dp[i][1] = Math.max(dp[i][1], dp[map.get(prev)][1] + 1);
            }
            map.put(arr[i], i);
        }
        return Math.max(dp[len-1][0], dp[len-1][1]);
    }

    public int longestSubsequence2(int[] arr, int difference) {
        int len=arr.length;
        int ans = 1;
        if (len == 1) {
            return ans;
        }
        for (int i=0;i<len;i++) {
            int next = arr[i] + difference;
            int start = i+1;
            int cur = 1;
            while (true) {
                int nextIdx = hasInt(arr, start, next);
                if (nextIdx < 0) break;
                cur ++;
                start = nextIdx+1;
                next = next +difference;
            }
            ans = Math.max(ans, cur);
        }
        return ans;
    }

    private int hasInt(int[] arr, int start, int next) {
        for (int i=start; i<arr.length;i++) {
            if (arr[i] == next) return i;
        }
        return -1;
    }

    @Test
    public void test() {
        System.out.println(longestSubsequence(new int[]{1,5,7,8,5,3,4,2,1}, -2));
    }
}
