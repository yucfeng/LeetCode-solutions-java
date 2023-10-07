package mergesort;

// https://leetcode.cn/problems/reverse-pairs/
public class ReversPairs {

    public int reversePairs(int[] nums) {
        int len = nums.length;
        if (len < 2) return 0;
        int[] temp = new int[len];
        return reversePairs(nums, 0, len - 1, temp);
    }

    // 如果题目要求不能改变数组，则需要复制一个新数组操作。
    private int reversePairs(int[] record, int left, int right, int[] temp) {
        if (left == right) return 0;
        int mid = (left + right) / 2;
        int leftPairs = reversePairs(record, left, mid, temp);
        int rightPairs = reversePairs(record, mid + 1, right, temp);
        int crossPairs = mergeAndCount(record, left, mid, right, temp);
        return leftPairs + rightPairs + crossPairs;
    }

    private int mergeAndCount(int[] record, int left, int mid, int right, int[] temp) {
        for (int i = left; i <= right; i++) {
            temp[i] = record[i];
        }

        int i = left;
        int j = mid + 1;
        int count = 0;
        while (i<=mid && j<=right) {
            if ((long)record[i] > (long) record[j] * 2L) {
                j++;
                count += mid - i + 1;
            } else {
                i++;
            }
        }

        i = left;
        j = mid + 1;
        for (int k = left; k <= right; k++) {
            // 考虑下标越界
            if (i == mid + 1) {
                record[k] = temp[j];
                j++;
            } else if (j == right + 1) {
                record[k] = temp[i];
                i++;
                // 开始归并
            } else if (temp[i] <= temp[j]) {
                record[k] = temp[i];
                i++;
            } else {
                record[k] = temp[j];
                j++;
//                count += mid - i + 1;
            }
        }
        return count;
    }
}
