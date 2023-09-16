package array.diffarray;

// VIP https://leetcode.cn/problems/range-addition/
/*
假设你有一个长度为n的数组，初始元素都是0，给你k个更新操作。
 */
public class RangeAddition {

    public int[] getModifiedArray(int k, int[][] updates) {
        int[] nums = new int[k];
        Difference df = new Difference(nums);
        for (int[] update: updates) {
            df.increment(update[0], update[1], update[2]);
        }

        return df.getNums();
    }
}
