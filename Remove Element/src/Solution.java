/**
 * Given an array nums and a value val, remove all instances of that value in-place and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 */
public class Solution {

    public static int removeElement(int[] nums, int val) {
        int res = 0;
        if (nums.length == 0) return 0;
        for (int i = 0; i < nums.length; i++) {
//            if (nums[res] == val) {
//                if (nums[res] != nums[i]) {
//                    nums[res] = nums[i];
//                    res++;
//                }
//            } else {
            if (nums[i] != val) {
                nums[res] = nums[i];
                res++;
            }
//            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2, 0, 0, 1, 1, 3, 4, 0};
        int len = removeElement(nums, 0);
        System.out.println(":" + len);
        for (int i = 0; i < len; i++) {
            System.out.println(nums[i]);
        }

    }
}
