/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * You may assume no duplicate exists in the array.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 */

public class Solution {
    public static int search(int[] nums, int target) {

//        if (nums[nums.length-1] == target) return nums.length-1;
//        else if (target > nums[nums.length-1])
//            binarySearch(nums, 0, x, target);
//        else
//            binarySearch(nums, x, nums.length, target);
        int res = -1;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end){
            int mid = start + (end - start)/2;    //防止溢位 0

            if (nums[mid] >= nums[start])
                if (nums[mid] >= target && target >= nums[start])
                    end = mid - 1 > 0? mid -1:0;
                else
                    start = mid + 1;
            if (nums[mid] <= nums[end])
                if (nums[mid] <= target &&  target <= nums[end])
                    start = mid + 1;
                else
                    end = mid - 1 > 0? mid -1:0;
            if (nums[mid] == target) {
                res = mid;
                break;
            }
        }
        return res;

    }

    public static int binarySearch(int[] arr, int start, int end, int hkey){
        int result = -1;

        while (start <= end){
            int mid = start + (end - start)/2;    //防止溢位
            if (arr[mid] > hkey)
                end = mid - 1;
            else if (arr[mid] < hkey)
                start = mid + 1;
            else {
                result = mid ;
                break;
            }
        }

        return result;

    }

    public static void main(String[] args) {
        int[] a = {1};
        System.out.println(search(a, 1));
    }
}
