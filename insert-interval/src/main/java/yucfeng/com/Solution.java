package yucfeng.com;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
lIndex = 1, rIndex = 3
输出：[[1,2],[3,10],[12,16]]
 */
public class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int left = newInterval[0];
        int right = newInterval[1];
        boolean placed = false;
        List<int[]> resList = new ArrayList<int[]>();
        for (int[] interval : intervals) {
            if (interval[0] > right) {
                // 在插入区间的右侧且无交集
                if (!placed) {
                    resList.add(new int[]{left, right});
                    placed = true;
                }
                resList.add(interval);
            } else if (interval[1] < left) {
                // 在插入区间的左侧且无交集
                resList.add(interval);
            } else {
                // 与插入区间有交集，计算它们的并集
                left = Math.min(left, interval[0]);
                right = Math.max(right, interval[1]);
            }
        }
        if (!placed) {
            resList.add(new int[]{left, right});
        }
        return resList.toArray(new int[resList.size()][]);
    }

    @Test
    public void test() {
        int[][] intervals = {{1, 3}, {6, 9}};
        int[] newInterval = {2, 5};
        Solution solution = new Solution();
        int[][] res = solution.insert(intervals, newInterval);
        Arrays.stream(res).toArray();
    }
}
