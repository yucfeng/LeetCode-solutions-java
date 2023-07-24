public class LongestContinuousIncreasingSubsequence {

    public int findLengthOfLCIS(int[] nums) {
        int maxLen = 0;
        int curLen = 0;
        int last = 0;
        for (int i=0;i<nums.length;i++){
            if (nums[i] > last) {
                curLen++;
                last = nums[i];
                maxLen = Math.max(maxLen, curLen);
            } else {
                curLen = 0;
                last = nums[i];
            }
        }
        return maxLen;
    }
}
