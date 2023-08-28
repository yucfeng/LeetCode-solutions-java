package dac;

import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

// https://leetcode.cn/problems/kth-largest-element-in-an-array/
public class KthLargestElement {

    private final static Random random = new Random(System.currentTimeMillis());

    // 时间复杂度为 O(n)
    // 快速选择
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        int target = len - k;

        int left = 0;
        int right = len - 1;
        while (true) {
            int pivotIndex = partition(nums, left, right);
            if (pivotIndex == target) {
                return nums[pivotIndex];
            } else if (pivotIndex < target) {
                left = pivotIndex + 1;
            } else {
                // pivotIndex > target
                right = pivotIndex - 1;
            }
        }
    }

    private int partition(int[] nums, int left, int right) {
        // Params:
        //bound – the upper bound (exclusive). Must be positive.
        //Returns:
        //the next pseudorandom, uniformly distributed int value between zero (inclusive) and bound (exclusive) from this random number generator's sequence
        int randomIndex = left + random.nextInt(right - left + 1);
        swap(nums, left, randomIndex);

        // all in nums[left + 1..le) <= pivot;
        // all in nums(ge..right] >= pivot;
        int pivot = nums[left];
        int le = left + 1;
        int ge = right;

        while (true) {
            while (le <= ge && nums[le] < pivot) {
                le++;
            }

            while (le <= ge && nums[ge] > pivot) {
                ge--;
            }

            if (le >= ge) {
                break;
            }
            swap(nums, le, ge);
            le++;
            ge--;
        }

        swap(nums, left, ge);
        return ge;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    // 时间复杂度为 O(klogn)
    // 使用优先队列 堆排序
    // PriorityQueue是最小堆
    public int findKthLargest2(int[] nums, int k) {
        // Implementation note: this implementation provides O(log(n)) time for the enqueuing and dequeuing methods (offer, poll, remove() and add);
        // linear time for the remove(Object) and contains(Object) methods; and constant time for the retrieval methods (peek, element, and size).
        PriorityQueue<Integer> heap = new PriorityQueue<>(k+1, Comparator.comparingInt(a -> a));
        for (int num : nums) {
            heap.add(num);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        return heap.peek();
    }
}
