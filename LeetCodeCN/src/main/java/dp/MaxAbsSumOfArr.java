package dp;

import org.junit.Test;

// https://leetcode.cn/problems/maximum-absolute-sum-of-any-subarray/
public class MaxAbsSumOfArr {

    // f[i]=max(nums[i],f[i−1]+nums[i])=max(f[i−1],0)+nums[i]
    public int maxAbsoluteSum(int[] nums) {
        int ans = 0, fMax = 0, fMin = 0;
        for (int x : nums) {
            fMax = Math.max(fMax, 0) + x;
            fMin = Math.min(fMin, 0) + x;
            ans = Math.max(ans, Math.max(fMax, -fMin));
        }
        return ans;
    }

    @Test
    public void test() {
        System.out.println(maxAbsoluteSum(new int[] {-3,-5,-3,-2,-6,3,10,-10,-8,-3,0,10,3,-5,8,7,-9,-9,5,-8}));
    }
}
