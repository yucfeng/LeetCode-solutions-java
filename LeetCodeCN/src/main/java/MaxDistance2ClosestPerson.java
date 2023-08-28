import org.junit.Test;

import java.util.Arrays;

// https://leetcode.cn/problems/maximize-distance-to-closest-person/
public class MaxDistance2ClosestPerson {

    // 贪心 + 双指针
    public int maxDistToClosest(int[] seats) {
        int res = 0;
        int l = 0;
        // 从左边开始找到第一个与人相邻的空位
        while (l < seats.length && seats[l] == 0) {
            l++;
        }
        res = l; // 左边缘是空位的情况
        while (l < seats.length) {
            int r = l + 1;
            while (r < seats.length && seats[r] == 0) {
                r++;
            }
            if (r == seats.length) {
                res = Math.max(res, r - l - 1);
            } else {
                res = Math.max(res, (r - l) / 2);
            }
            l = r; // 新的区间
        }
        return res;
    }

    // 动态规划
    public int maxDistToClosest2(int[] seats) {
        int len = seats.length;
        if (len == 2) {
            return 1;
        }

        int idx = 0;
        for (int i = 0; i < len; i++) {
            if (seats[i] == 0) {
                idx = i;
                break;
            }
        }

        int[] ans = new int[len];
        if (idx==0) {
            int tmp = 0;
            int i = idx;
            while (seats[i] != 1) {
                tmp++;
                i++;
                idx ++;
            }
            ans [0] = tmp;
        }

        for (int i = idx; i < len; i++) {
           dp(seats, i, ans);
        }
        Arrays.sort(ans);
        return ans[len - 1];
    }

    private int dp(int[] seats, int i, int[] ans) {
        if (seats[i]==1) return 0;
        if (i + 1 == seats.length) {
            ans[i] = ans[i - 1] + 1;
            return ans[i];
        }
        if (seats[i - 1] == 1 || seats[i + 1] == 1) {
            ans[i] = 1;
            return ans[i];
        }
        ans[i] = Math.min(ans[i - 1] + 1, dp(seats, i + 1, ans) + 1);
        return ans[i];
    }

    @Test
    public void test() {
        System.out.println(maxDistToClosest(new int[]{0,0,0,0,1,0,1}));
    }
}
