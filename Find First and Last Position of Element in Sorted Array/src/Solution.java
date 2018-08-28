/**
 * Given an array of integers nums sorted in ascending order,
 * find the starting and ending position of a given target value.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * If the target is not found in the array, return [-1, -1].
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 */

public class Solution {
    public static int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        return binarySearch(nums, 0, nums.length-1, target, res);
    }

    public static int[] binarySearch(int[] arr, int start, int end, int hkey, int[] res) {

        if (start > end)
            return res;

        int mid = start + (end - start) / 2;    //防止溢位
        if (arr[mid] > hkey)
            return binarySearch(arr, start, mid - 1, hkey, res);
        if (arr[mid] < hkey)
            return binarySearch(arr, mid + 1, end, hkey, res);
        if (arr[start] != hkey)
            return binarySearch(arr, start + 1, end, hkey, res);
        if (arr[end] != hkey)
            return binarySearch(arr, start, end-1, hkey, res);
        if (arr[end] == hkey) {
            res[1] = end;
        }
        if (arr[start] == hkey) {
            res[0] = start;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {5,5,7,8,8,10};
        int[] res = searchRange(nums, 10);
        System.out.println(res[0] + " " + res[1]);
    }
}
