import org.junit.Test;

public class MaximumSubarray {
    /* 动态规划
    动态规划转移方程：
    f(i)=max{f(i−1)+nums[i],nums[i]}
    */
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int pre = 0;
        for (int n:nums) {
            pre = Math.max(pre + n, n);
            res = Math.max(res, pre);
        }
        return res;
    }
/*
-2,1

-1, 2, 1

2, -3, 2, 1
 */
    // D & C
    private int getMaxSubArray(int[] nums) {
        if (nums.length == 1) return nums[0];
        int[] subNums = new int[nums.length - 1];
        if (nums[nums.length - 1] < 0) {
            System.arraycopy(nums, 0, subNums, 0, nums.length - 1);
            return getMaxSubArray(subNums);
        } else if (nums[0] < 0){
            System.arraycopy(nums, 1, subNums, 0, nums.length - 1);
            return getMaxSubArray(subNums);
        } else {
            return sum(nums); // TODO
        }
    }

    private int sum(int[] nums) {
        int res = 0;
        for (int n : nums) {
            res += n;
        }
        return res;
    }

    @Test
    public void test() {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }
}
