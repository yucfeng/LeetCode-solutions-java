import org.junit.Test;
// https://leetcode.cn/problems/rotate-array
public class RotateArray {

    public void rotate3(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }
    }

    public void rotate(int[] nums, int k) {
        int[] tmp = new int[nums.length];
        k = k % nums.length;
        System.arraycopy(nums, nums.length - k, tmp, 0, nums.length - (nums.length - k));
        System.arraycopy(nums, 0, tmp, k, nums.length - k);
        System.arraycopy(tmp, 0, nums, 0, nums.length);
    }

    public void rotate2(int[] nums, int k) {
        int[] tmp = new int[nums.length];
        k = k % nums.length;
        for (int i = nums.length - k; i < nums.length; i++) {
            tmp[i - (nums.length - k)] = nums[i];
        }
        for (int i = 0; i < nums.length - k; i++) {
            tmp[i + k] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = tmp[i];
        }
    }

    @Test
    public void test() {
        rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);
    }
}
