/**
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 The replacement must be in-place and use only constant extra memory.
 1 3 2 -> 2 1 3
 3 4 2 9 3 8 (1 7) ->  3 4 2 9 3 8 7 1
 3 4 2 9 (3 8) 7 1 ->  3 4 2 9 (7 1 3 8)
 * Author: yucfeng
 * Date: 2018/8/20
 */

public class Solution {
    public static void nextPermutation(int[] nums) {
        // compare from right to left
        // find first left < right number
        int i=nums.length-1;
        boolean max = true;
        for (; i > 0; i--) {
            if (nums[i-1] < nums[i]) {
                int biggerNum = nums[i];
                int lastIndex = i;
                for (int j= i; j<nums.length; j++) {
                    if (biggerNum > nums[j] && nums[j] > nums[i-1]) {
                        biggerNum = nums[j];
                        lastIndex = j;
                    }
                }
                int tmp = nums[i-1];
                nums[i-1] = biggerNum;
                nums[lastIndex] = tmp;
                sort(nums, i, nums.length);
                max = false;
                break;
            }
        }
        if (max) {
            // sorted in ascending order
            sort(nums, 0, nums.length);
        }
    }

    private static void sort(int[] nums, int start, int end) {
        for (int i= start; i<end; i++) {
            for (int j = i+1; j < end; j++) {
                if (nums[i] > nums[j]) {
                    int tmp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {3 ,4 ,2, 9 ,3, 8,7, 1};
        nextPermutation(a);
        for(int n : a) {
            System.out.print(n);}
    }
}
