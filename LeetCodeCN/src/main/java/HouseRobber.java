// https://leetcode.cn/problems/house-robber/
public class HouseRobber {


    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        int[] dp = new int[nums.length+1];

        dp[1] = nums[0];
        for (int i=2; i<=nums.length; i++) {
            dp[i] = Math.max(nums[i-1] + dp[i-2], dp[i-1]);
        }

        return dp[nums.length];
    }

    // f(n) = nums[n] + f(n-2)
    //      = f(n-1)
    public int rob2(int[] nums) {
        return f(nums, nums.length-1); // 超时
    }

    private int f(int[] nums, int n) {
        if (n < 0) return 0;
        if (n == 0) return nums[0];
        if (n == 1) return Math.max(nums[0], nums[1]);
        return Math.max(nums[n] + f(nums, n-2), f(nums, n-1));
    }
}
