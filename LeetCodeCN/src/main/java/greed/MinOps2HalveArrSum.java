package greed;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

// https://leetcode.cn/problems/minimum-operations-to-halve-array-sum/
public class MinOps2HalveArrSum {


    // 优先级队列
    public int halveArray2(int[] nums) {
        PriorityQueue<Double> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int num : nums) {
            pq.offer((double) num);
        }
        int res = 0;
        double sum = 0;
        for (int num : nums) {
            sum += num;
        }
        double sum2 = 0.0;
        while (sum2 < sum / 2) {
            double x = pq.poll();
            sum2 += x / 2;
            pq.offer(x / 2);
            res++;
        }
        return res;
    }

    int ans = 0;

    public int halveArray(int[] nums) {
        if (nums.length == 1) return 1;
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        Arrays.sort(nums);
        double half = sum / 2.0;
        double div = 0.0;
        double[] tmp = new double[nums.length];

        int index = nums.length - 1;
        double max = nums[index];
        tmp[index] = max;

        while (div < half) {
            double cur = max / 2.0;
            tmp[index] = tmp[index] / 2.0;
            div += cur;
            ans++;

            int maxIdx= getMax(tmp, index);
            max = tmp[maxIdx];
            if (max < nums[index - 1]) {
                index--;
                max = nums[index];
                tmp[index] = nums[index];
            } else {
                tmp[maxIdx] = max/2.0;
            }
        }

        return ans;
    }

    private int getMax(double[] tmp, int index) {
        double max = 0.0;
        int ans = -1;
        for (int i=index; i<tmp.length;i++) {
            if (max <= tmp[i]) {
                max = tmp[i];
                ans = i;
            }
        }
        return ans;
    }

    private void greed(int[] nums, double half, double div, int index, double[] tmp) {
        if (div >= half) return;

        double cur = tmp[index] / 2.0;
        div += cur;
        ans++;

        tmp[index] = tmp[index] / 2.0;
        cur = getMax(cur, tmp, index);
        // 判断下一个减半的数
        if (cur >= nums[index - 1]) {
            greed(nums, half, div, index, tmp);
        } else {
            tmp[index-1] = nums[index-1];
            greed(nums, half, div, index - 1, tmp);
        }
    }

    private double getMax(double cur, double[] tmp, int index) {
        double ans = cur;
        for (int i=index; i<tmp.length;i++) {
            if (cur <= tmp[i])ans =  tmp[i];
        }
        return ans;
    }

    @Test
    public void test() {
        System.out.println(halveArray(new int[]{18,22,62,61,1,88,17,98,38,32,51,57,7,29,40,61,62,13,89,41,73,85,88,60,59,76,71,76,76,41,29,43,19,9,79}));
    }

}
