package abs;

import org.junit.Test;

import java.util.Arrays;

// https://leetcode.cn/problems/minimum-size-subarray-sum/
public class MinimumSizeSubarraySum {

    public int minSubArrayLen(int target, int[] nums) {
        int len = nums.length;
        int[] sums = new int[len+1];
        for (int i=1; i<=len;i++){
            sums[i] = sums[i-1] + nums[i-1];
        }

        int ans = Integer.MAX_VALUE;
        // sums[bound]−sums[i−1]>=target
        for (int i=1;i<=len;i++) {
            int boundSum = target + sums[i-1];
            // index of the search key, if it is contained in the array; otherwise, (-(insertion point) - 1).
            // The insertion point is defined as the point at which the key would be inserted into the array:
            // the index of the first element greater than the key, or a.length if all elements in the array are less than the specified key.
            int bound = Arrays.binarySearch(sums, boundSum);
            if (bound < 0) bound = -bound-1;
            if (bound < len) ans = Math.min(ans, bound -(i-1));
        }
        return ans;
    }

    public int minSubArrayLen2(int target, int[] nums) {
        int len = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum < target) return 0;
        if (sum == target) return len;

        int ans = Integer.MAX_VALUE;
        int l = 0, r = 0;
        sum =0;
        while (r < len) {
            sum += nums[r];
            while (sum >= target) {
                ans = Math.min(ans, r-l+1);
                sum -= nums[l];
                l++;
            }
            r ++;
        }
        return ans;
    }

    @Test
    public void test() {
        System.out.println(minSubArrayLen(213, new int[]{12,28,83,4,25,26,25,2,25,25,25,12}));
    }
}
