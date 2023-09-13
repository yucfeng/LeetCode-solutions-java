package array;

import org.junit.Test;

// https://leetcode.cn/problems/remove-element/
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) return 0;
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }

    @Test
    public void test() {
        System.out.println(removeElement(new int[]{3, 2, 2, 3}, 3));
    }
}
