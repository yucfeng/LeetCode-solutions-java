package array.presum;

public class NumArray {

    // [3, 5, 2, -1]
    int[] preSums; // [0, 3, 8, 10, 9]

    public NumArray(int[] nums) {
        this.preSums = new int[nums.length+1];
        for (int i=1;i<=nums.length;i++) {
            preSums[i] = preSums[i-1] + nums[i-1];
        }
    }

    public int sumRange(int left, int right) {
        return preSums[right+1] - preSums[left];
    }

//    int[] nums;
//
//    public NumArray(int[] nums) {
//        this.nums = nums;
//    }
//
//    public int sumRange(int left, int right) {
//        int ans=0;
//        for (int i=left;i<=right;i++) {
//            ans+=nums[i];
//        }
//        return ans;
//    }
}
