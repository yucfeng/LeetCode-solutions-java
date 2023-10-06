package mergesort;

import java.util.ArrayList;
import java.util.List;
// https://leetcode.cn/problems/count-of-smaller-numbers-after-self/description/
public class CountSmallerNumbersAfterSelf {
    List<Integer> ans;
    public List<Integer> countSmaller(int[] nums) {
        int len = nums.length;
        ans = new ArrayList<>(len);
        if (len < 2) return ans;
        int[] temp = new int[len];
        reversePairs(nums, 0, len - 1, temp);
        return ans;
    }

    private int reversePairs(int[] nums, int left, int right, int[] temp) {
        if (left == right) return 0;
        int mid = (left + right) / 2;
        int leftPairs = reversePairs(nums, left, mid, temp);
        int rightPairs = reversePairs(nums, mid + 1, right, temp);
        if (nums[mid] <= nums[mid + 1]) {
            return leftPairs + rightPairs;
        }
        int crossPairs = mergeAndCount(nums, left, mid, right, temp);
        return leftPairs + rightPairs + crossPairs;
    }

    private int mergeAndCount(int[] nums, int left, int mid, int right, int[] temp) {
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }

        int i = left;
        int j = mid + 1;
        int count = 0;
        for (int k = left; k <= right; k++) {
            // 考虑下标越界
            if (i == mid + 1) {
                nums[k] = temp[j];
                j++;
            } else if (j == right + 1) {
                nums[k] = temp[i];
                i++;
                count += j - mid - 1;
                // 开始归并
            } else if (temp[i] <= temp[j]) {
                nums[k] = temp[i];
                i++;
                count += j - mid - 1;  // (j - 1) - (mid + 1) + 1
            } else {
                nums[k] = temp[j];
                j++;
//                count += mid - i + 1;
            }
        }
        return count;
    }
}
