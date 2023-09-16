package array.diffarray;

import java.util.Arrays;

// https://leetcode.cn/problems/car-pooling/
public class CarPooling {

    public boolean carPooling(int[][] trips, int capacity) {
        int[] nums = new int[1000];
        Difference df = new Difference(nums);
        for (int[] trip: trips) {
            df.increment(trip[1]-1, trip[2]-1, trip[0]);
        }
        for (int num : df.getNums()) {
            if (num > capacity) return false;
        }
        return true;
    }
}
