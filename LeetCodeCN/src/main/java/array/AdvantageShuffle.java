package array;

import java.util.Arrays;
import java.util.PriorityQueue;

// https://leetcode.cn/problems/advantage-shuffle/
public class AdvantageShuffle {

    public int[] advantageCount(int[] nums1, int[] nums2) {
        PriorityQueue<int[]> nums2pq = new PriorityQueue<>((pair1, pair2) -> pair2[1] - pair1[1]);
        for (int i=0;i<nums2.length;i++) {
            nums2pq.add(new int[] {i, nums2[i]});
        }

        Arrays.sort(nums1);
        int[] ans = new int[nums1.length];
        // 设置左右双指针
        int left =0, right = nums1.length-1;
        while (!nums2pq.isEmpty()) {
            int[] pair = nums2pq.poll();
            int i = pair[0], num = pair[1];
            if (nums1[right] > num) {
                ans[i] = nums1[right];
                right--;
            } else {
                ans[i] = nums1[left];
                left++;
            }
        }
        return ans;
    }
}
