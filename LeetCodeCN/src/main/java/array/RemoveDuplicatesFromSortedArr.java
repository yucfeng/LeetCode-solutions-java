package array;

// https://leetcode.cn/problems/remove-duplicates-from-sorted-array/
public class RemoveDuplicatesFromSortedArr {

    public int removeDuplicates(int[] nums) {
        int slow = 0;
        int fast = 1;
        while (fast < nums.length) {
            if (nums[slow] != nums[fast]) {
                nums[slow + 1] = nums[fast];
                slow ++;
            }
            fast ++;
        }
        return slow + 1;
    }
}
