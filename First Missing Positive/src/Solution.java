import java.util.Arrays;

/**
 * Given an unsorted integer array, find the smallest missing positive integer.
 * Your algorithm should run in O(n) time and uses constant extra space.
 */
public class Solution {
// 先排序O(NlogN)，再查找O(N)
    public static int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        if (nums.length == 0) return 1;
        int res = nums[nums.length-1] + 1;
        if (nums.length == 1 && nums[0] != 1) {
            return 1;
        }
        // find first positive
        boolean find = false;
        for (int i=0; i< nums.length; i++) {
            if (nums[i] <= 0) {
                continue;
            } else if (!find) {
                find = true;
                if (nums[i] != 1) return 1;
            }
            if (i > 0 && nums[i] - nums[i-1] > 1 && nums[i-1] >= 0) {
                return nums[i-1]+1;
            }
        }
        return res > 0? res: 1;
    }

    // 桶的思想 + 抽屉原理
    // 根据数组下标交换元素
    public static int firstMissingPositive2(int[] nums) {
        for(int i=0; i<nums.length; i++) {
            while (nums[i] > 0 && nums[i] <= nums.length && nums[nums[i]-1] != nums[i]) {  // 两层循环最多交换 n 次
                swap(nums, i, nums[i]);
            }
        }

        for (int i=0; i<nums.length; i++) {
            if (nums[i] != i+1) {
                return i+1;
            }
        }

        return nums.length + 1;
    }

    private static void swap(int[] nums, int i, int num) {
        int tmp = nums[num-1];
        nums[num-1] = num;
        nums[i] = tmp;
    }

// 使用索引作为哈希键 以及 元素的符号作为哈希值 来实现是否存在的检测


    public static void main(String[] args) {
        int[] nums = {3,4,-1,1};
        System.out.println(firstMissingPositive2(nums));
    }
}
