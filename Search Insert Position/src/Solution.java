/**
 * Given a sorted array and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 * You may assume no duplicates in the array.
 * [1,3,5,6], 2
 * Output: 1
 */

public class Solution {
    public static int searchInsert(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length-1, target);
    }

    public static int binarySearch(int[] arr, int start, int end, int hkey){
        if (start > end)
            return start;

        int mid = start + (end - start)/2;    //防止溢位
        if (arr[mid] > hkey)
            return binarySearch(arr, start, mid - 1, hkey);
        if (arr[mid] < hkey)
            return binarySearch(arr, mid + 1, end, hkey);
        return mid;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        System.out.println(searchInsert(nums, 3));
    }
}
