import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.cn/problems/combination-sum-ii/submissions/
 * 以{1, 1, 2, 5, 6, 7}，target = 8 为例模拟一下解题流程
 * 首先排个序，是为了以后能方便的剪枝以及跳过重复的解
 *
 * 遍历数组，进行累加，若小于 8 就继续遍历，得到 [1, 1, 2]
 * 下一个 5 添加进来后就大于 8 了，所以直接 break 这次遍历，并从列表中退出 2，然后从2的下一个元素继续遍历，得到 [1, 1, 5]
 * 下一个 6 添加进来后大于 8，所以去掉 5，从将5 后一个元素继续得到 [1, 1, 6]，判断等于 8，所以保存该解，因为已经排好了序，所以后面的元素不用再看了，就 break这次循环
 * 这时列表中只有 [1, 1]， 将第二个 1 退出，从它的后一个元素开始遍历，得到 [1, 2, 5]，保存该解并break这次循环
 * 退出2，从它的下一个元素开始，得到[1, 5]
 * 下一个 6 添加进来后大于 8，所以去掉5，添加6，得到[1, 6]
 * 下一个 7 添加进来后大于 8，所以去掉6，添加7，得到[1, 7]，保存该解并break这次循环
 * 退出1，从它下一个元素开始，因为下一个元素还是1，所以跳过它，再下一个元素是2，于是从2开始得到[2, 5]
 * 下一个 6 添加进来后大于 8，所以去掉5，添加6，得到[2, 6]，保存该解并break这次循环
 * 退出2，从它下一个元素 5 开始，得到 [5]
 * 下一个 6 添加进来后大于 8，所以去掉5，添加6，得到 [6]
 * 下一个 7 添加进来后大于 8，所以去掉6，添加7，得到 [7]
 */
public class CombinationSum2 {

    @Test
    public void main() {
        int[] candidates = {2,5,2,1,2};
        System.out.println(combinationSum2(candidates,5));
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        if (candidates == null || candidates.length == 0 || target < 0) {
            return lists;
        }

        Arrays.sort(candidates);
        // 已添加的数
        List<Integer> list = new ArrayList<>();
        dfs(lists, list, candidates, target, 0);
        return lists;
    }

    private static void dfs(List<List<Integer>> lists, List<Integer> list, int[] candidates, int target, int start) {
        //递归的终止条件
        if (target < 0) {
            return;
        }
        if (target == 0) {
            lists.add(new ArrayList<>(list));
        } else {
            for (int i = start; i < candidates.length; i++) {
                //因为这个数和上个数相同，所以从这个数开始的所有情况，在上个数里面都考虑过了，需要跳过
                if (i != start && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                list.add(candidates[i]);
                dfs(lists, list, candidates, target - candidates[i], i + 1);
                list.remove(list.size() - 1);
            }
        }
    }
}
