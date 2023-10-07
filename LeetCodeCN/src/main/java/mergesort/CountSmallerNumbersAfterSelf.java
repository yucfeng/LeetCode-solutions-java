package mergesort;

import java.util.ArrayList;
import java.util.List;
// https://leetcode.cn/problems/count-of-smaller-numbers-after-self/description/
public class CountSmallerNumbersAfterSelf {
    int[] ansArr;
    public List<Integer> countSmaller(int[] nums) {
        int len = nums.length;
        List<Integer> ans = new ArrayList<>(len);
        if (len == 1) {
            ans.add(0);
            return ans;
        }
        int[] temp = new int[len];
        int[] indexes = new int[len];
        ansArr = new int[len];
        for (int i=0;i<len;i++) {
            indexes[i] = i;
        }
        reversePairs(nums, 0, len - 1, indexes, temp);
        for(int i : ansArr) {
            ans.add(i);
        }
        return ans;
    }

    private void reversePairs(int[] nums, int left, int right, int[] indexes, int[] temp) {
        if (left == right) return;
        int mid = (left + right) / 2;
        reversePairs(nums, left, mid, indexes, temp);
        reversePairs(nums, mid + 1, right, indexes, temp);
        if (nums[indexes[mid]] <= nums[indexes[mid + 1]]) {
            return;
        }
        mergeAndCount(nums, left, mid, right, indexes, temp);
    }

    private void mergeAndCount(int[] nums, int left, int mid, int right, int[] indexes, int[] temp) {
        for (int i = left; i <= right; i++) {
            temp[i] = indexes[i];
        }

        int i = left;
        int j = mid + 1;
        for (int k = left; k <= right; k++) {
            // 考虑下标越界
            if (i == mid + 1) {
                indexes[k] = temp[j];
                j++;
            } else if (j == right + 1) {
                indexes[k] = temp[i];
                i++;
                ansArr[indexes[k]] += j - mid - 1;
                // 开始归并
            } else if (nums[temp[i]] <= nums[temp[j]]) {
                indexes[k] = temp[i];
                i++;
                ansArr[indexes[k]] += j - mid - 1;  // (j - 1) - (mid + 1) + 1
            } else {
                indexes[k] = temp[j];
                j++;
            }
        }
    }
}
