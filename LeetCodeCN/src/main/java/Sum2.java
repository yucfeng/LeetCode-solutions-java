// https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted
public class Sum2 {

    // 标从 1 开始的整数数组 numbers, 该数组已按 非递减顺序排列
    // 双指针
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length-1;
        while (left < right) {
            if (numbers[left] + numbers[right] == target) break;
            if (numbers[left] + numbers[right] > target) {
                right --;
                continue;
            }
            if (numbers[left] + numbers[right] < target) {
                left ++;
            }
        }
        return new int[]{left+1, right+1};
    }
}
