// https://leetcode.cn/problems/next-permutation/
public class NexPermutation {

    /*
    我们需要将一个左边的「较小数」与一个右边的「较大数」交换，以能够让当前排列变大，从而得到下一个排列。
同时我们要让这个「较小数」尽量靠右，而「较大数」尽可能小。当交换完成后，「较大数」右边的数需要按照升序重新排列。
这样可以在保证新排列大于原来排列的情况下，使变大的幅度尽可能小。
     */

    public void nextPermutation(int[] nums) {
        int len = nums.length;
        if (len==1) return;
        int l=len-2, r=len-1;
        while (l>=0 && nums[l] >= nums[l+1]) {
            l --;
        }
        if (l>=0) {
            while (r>l&& nums[l] >=nums[r]) {
                r--;
            }
            swap(nums, l , r);
        }
        sortFrom(nums, l+1);
    }

    private void sortFrom(int[] nums, int i) {
        int l = i, r = nums.length - 1;
        while (l < r) {
            swap(nums, l, r);
            l++;
            r--;
        }
    }

    private void swap(int[] nums, int l, int r) {
        int tmp = nums[l];
        nums[l] = nums[r];
        nums[r]=tmp;
    }



}
