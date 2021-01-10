import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 */
class Solution2 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        boolean[] used = new boolean[len]; // 空间换时间
        Integer[] lastNums = new Integer[len]; //
        List<Integer> path = new ArrayList<>();

        dfs(nums, len, 0, path, used, res, lastNums);
        return res;
    }
    private void dfs(int[] nums, int len, int depth,
                     List<Integer> path, boolean[] used,
                     List<List<Integer>> res, Integer[] lastNums) {
        if (depth == len) {
            List<Integer> pathToAdd = new ArrayList<>(path); // 浅拷贝
            res.add(pathToAdd);
            return;
        }

        for (int i = 0; i < len; i++) {
            if (!used[i] && (lastNums[i] == null || !lastNums[i].equals(nums[i]))) {
                path.add(nums[i]);
                used[i] = true;

                dfs(nums, len, depth + 1, path, used, res, lastNums);
                // 回溯
                used[i] = false;
                lastNums[i] = path.get(path.size() - 1);
                path.remove(path.size() - 1);
                // 回溯后，不能再接着搜索相同的值

            }
        }
    }

    private static int[] remove(int[] nums) {
        int[] lessNums = new int[nums.length - 1];
        for (int i=0; i<nums.length-1; i++) {
            lessNums[i] = nums[i];
        }
        return lessNums;
    }

    public static BigDecimal factorial(int n) {
        BigDecimal result = new BigDecimal(1);
        BigDecimal a;
        for (int i = 2; i <= n; i++) {
            a = new BigDecimal(i);
            result = result.multiply(a);
        }
        return result;
    }

    public static int simpleCircle(int num) {
        int sum = 1;
        for (int i = 1; i <= num; i++) {
            sum *= i;
        }
        return sum;
    }

    public static void main(String[] ar) {
        Solution2 solution = new Solution2();
        int[] a = {1, 1, 3};
        System.out.println(solution.permuteUnique(a));
    }
}