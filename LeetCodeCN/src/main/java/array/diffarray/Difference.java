package array.diffarray;

// 差分数组工具类
public class Difference {

    private int[] diff;

    /**
     * 输入一个初始数组，区间操作的对象
     *
     * @param nums 初始数组
     */
    public Difference(int[] nums) {
        assert nums.length > 0;
        diff = new int[nums.length];
        diff[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            diff[i] = nums[i] - nums[i - 1];
        }
    }

    public int[] getNums() {
        int[] res = new int[diff.length];
        res[0] = diff[0];
        for (int i = 1; i < diff.length; i++) {
            res[i] = res[i - 1] + diff[i];
        }
        return res;
    }

    /**
     * 给闭区间[i,j]增加val
     *
     * @param l   左边界
     * @param r   有边界
     * @param val 可以为负数
     */
    public void increment(int l, int r, int val) {
        diff[l] += val;
        if (r + 1 < diff.length) {
            diff[r + 1] -= val;
        }
    }
}
