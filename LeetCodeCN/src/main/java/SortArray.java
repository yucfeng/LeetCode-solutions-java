import java.util.Arrays;
import java.util.Random;

// https://leetcode.cn/problems/sort-an-array/
public class SortArray {

    // 冒泡 超时
    public int[] sortArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) { // 两两比较
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j+1);
                }
            }
        }
        Arrays.sort(nums);
        return nums;
    }

    // 快排 超时
    public int[] sortArray2(int[] nums) {
//        Arrays.sort(nums);
        quickSort(nums, 0, nums.length-1);
        return nums;
    }

    // 归并
    public int[] sortArray3(int[] nums) {
        mergeSort(nums);
        return nums;
    }

    public void quickSort(int[] array, int start, int end) {
        if (array.length < 1 || start < 0 || end >= array.length || start > end) return;
        int smallIndex = partition(array, start, end);
        if (smallIndex > start)
            quickSort(array, start, smallIndex - 1);
        if (smallIndex < end)
            quickSort(array, smallIndex + 1, end);
    }

    int partition(int[] array, int start, int end) {
        int pivot = new Random().nextInt(end - start + 1) + start;
        int smallIndex = start - 1;
        swap(array, pivot, end);
        for (int i = start; i <= end; i++)
            if (array[i] <= array[end]) {
                smallIndex++;
                if (i > smallIndex)
                    swap(array, i, smallIndex);
            }
        return smallIndex;
    }

    public int[] mergeSort(int[] array) {
        if (array.length < 2) return array;
        int mid = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);
        return merge(mergeSort(left), mergeSort(right));
    }

    int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        for (int index = 0, i = 0, j = 0; index < result.length; index++) {
            if (i >= left.length)
                result[index] = right[j++];
            else if (j >= right.length)
                result[index] = left[i++];
            else if (left[i] > right[j])
                result[index] = right[j++];
            else
                result[index] = left[i++];
        }
        return result;
    }

    void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
