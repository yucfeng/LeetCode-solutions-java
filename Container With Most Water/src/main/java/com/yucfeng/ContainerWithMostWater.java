package com.yucfeng;


import org.junit.Test;

/**
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 * https://leetcode-cn.com/problems/container-with-most-water/
 */
public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int res = 0;
        int len = height.length;
        for (int i=0; i<len; i++) {
            for (int j=i; j>0; j--) {
                res = Math.max(res, Math.min(height[i], height[j])*(i-j));
            }
            for (int j=i; j<len; j++) {
                res = Math.max(res, Math.min(height[i], height[j])*(j-i));
            }
        }
        return res;
    }

    // 双指针
    public int maxArea2(int[] height) {
        int res = 0;
        int len = height.length;
        int l = 0, r = len-1;
        while (r > l) {
            res = Math.max(res, Math.min(height[r], height[l]) * (r - l));
            if (height[l] < height[r]) l++;
            else r--;
        }
        return res;
    }

    @Test
    public void test() {
        int[] h = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea2(h));
    }
}
