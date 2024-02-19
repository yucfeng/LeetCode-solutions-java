package array;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

// https://leetcode.cn/problems/merge-sorted-array/
public class MergeSortedArray {

    // O(m + n)
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p = m - 1;
        int q = n - 1;
        while (p >= 0 || q >= 0) {
            if (p < 0) {
                nums1[q] = nums2[q];
                q--;
                continue;
            }
            if (q < 0) {
                break;
            }

            if (nums1[p] >= nums2[q]) {
                nums1[p + q + 1] = nums1[p];
                p--;
            } else {
                nums1[p + q + 1] = nums2[q];
                q--;
            }
        }
    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        Queue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < m; i++) {
            queue.add(nums1[i]);
        }
        for (int i = 0; i < n; i++) {
            queue.add(nums2[i]);
        }
        for (int i = 0; i < m + n; i++) {
            nums1[i] = queue.poll();
        }
    }
}
