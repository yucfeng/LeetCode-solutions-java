import org.junit.Test;

import java.util.Arrays;

// https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/
public class FindFirstAndLastPos {

    public int[] searchRange2(int[] nums, int target) {
        int leftIdx = binarySearch(nums, target, true);
        int rightIdx = binarySearch(nums, target, false) - 1;
        if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target) {
            return new int[]{leftIdx, rightIdx};
        }
        return new int[]{-1, -1};
    }

    public int binarySearch(int[] nums, int target, boolean lower) {
        int left = 0, right = nums.length - 1, ans = nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }


    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[]{-1, -1};
        int len = nums.length;
        if (len == 0) return ans;

        int idx = Arrays.binarySearch(nums, target);
        if (idx < 0) return ans;
        ans[0] = idx;
        ans[1] = idx;
        int l = idx-1, r= idx+1;
        while (l >= 0) {
            if (nums[l] == target) {
                ans[0] = l;
                l --;
            } else break;
        }
        while (r < len) {
            if (nums[r] == target) {
                ans[1] = r;
                r ++;
            } else break;
        }

        return ans;
    }

    @Test
    public void test() {
        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6)));
    }
}
