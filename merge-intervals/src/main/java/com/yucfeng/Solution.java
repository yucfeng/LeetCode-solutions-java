package com.yucfeng;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
 * and return an array of the non-overlapping intervals that cover all the intervals in the input.
 */
class Solution {
    public static int[][] merge(int[][] intervals) {
        if (intervals.length <= 0) {
            return intervals;
        }
        // sort intervals first
        for (int i = 0; i < intervals.length; i++) {
            for (int j = 0; j < intervals.length - i - 1; j++) {
                if (intervals[j][0] > intervals[j+1][0]) {
                    int[] tmp = intervals[j+1];
                    intervals[j+1] = intervals[j];
                    intervals[j] = tmp;
                }
            }

        }

        List<int[]> resList = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= end && intervals[i][1] >= end) {
                end = intervals[i][1];
            } else {
                if (intervals[i][1] >= end) {
                    resList.add(new int[]{start, end});
                    start = intervals[i][0];
                    end = intervals[i][1];
                }
            }
        }
        resList.add(new int[]{start, end});
        return resList.toArray(new int[resList.size()][]);
    }

    public static void main(String[] a) {
        int[][] intervals = {{4,5},{1,4},{0,1}};
        System.out.println(Arrays.asList(merge(intervals)));
    }
}
