/**
 * Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * It doesn't matter what values are set beyond the returned length.
 */
public class Solution {
    public static int removeDuplicates(int[] nums) {
//        int oriLen = nums.length;
//        int res = oriLen;
//        if (oriLen == 0 || oriLen == 1) return res;
//        int curIndex = 0;
//        int curNum = nums[curIndex];
//        for (int i = 0; i < oriLen; i++) {
//            if (i == oriLen - 1) break;
//            if (curNum == nums[i + 1]) {
//                res--;
//            } else {
//                nums[curIndex + 1] = nums[i + 1];
//                curIndex = curIndex+1;
//                curNum = nums[i + 1];
//            }
//        }
        if (nums.length < 2) return nums.length;
        int res = 1;
        for (int i = 1; i< nums.length; i++) {
            if (nums[res-1] != nums[i]) {
                nums[res] = nums[i];
                res ++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 0, 1, 1, 3, 4, 4};
        int len = removeDuplicates(nums);
        System.out.println(":" + len);
        for (int i = 0; i < len; i++) {
            System.out.println(nums[i]);
        }

    }
}
