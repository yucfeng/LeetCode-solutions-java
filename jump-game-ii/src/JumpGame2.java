/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your Maximum jump length at that position.
 * Your goal is to reach the last index in the minimum number of jumps.
 */
public class JumpGame2 {

    public static int jump(int[] nums) {
        int len = nums.length;
        int steps = 0;
        if (len <= 1) return 0;
        int end = 0;
        int index = end;
        int max = index;
        // 取得i + nums[i]中最大值，然后计步
        while (end < len-1) {
           max = Math.max(max, index + nums[index]);
            if (index == end) {
                steps++;
                end = max;
            }
            index++;
        }
        return steps;
    }

    public static void main(String[] asd) {
        int[] nums = {2,3,1,1,4}; //{1, 2}; //{1,2, 1,1,1}; //
        System.out.println(jump(nums));
    }
}
