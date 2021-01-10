import java.util.*;

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        Arrays.sort(nums);
        boolean[] used = new boolean[len]; // 空间换时间
        Deque<Integer> path = new ArrayDeque<>(len); // stack

        dfs(nums, len, 0, path, used, res);
        return res;
    }

    private void dfs(int[] nums, int len, int depth,
                     Deque<Integer> path, boolean[] used,
                     List<List<Integer>> res) {
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) {
                continue;
            }
            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;

                dfs(nums, len, depth + 1, path, used, res);
                // 回溯
                used[i] = false;
                path.removeLast(); // path.remove(path.size() - 1); --> return removeFirstOccurrence(o);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.permuteUnique(nums);
        System.out.println(lists);
    }
}
