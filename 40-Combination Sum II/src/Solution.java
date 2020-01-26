import java.util.ArrayList;
import java.util.List;

/**
 * Given a collection of candidate numbers (candidates) and a target number (target),
 * find all unique combinations in candidates where the candidate numbers sums to target.
 Each number in candidates may only be used once in the combination.
 Note:
 All numbers (including target) will be positive integers.
 The solution set must not contain duplicate combinations.
 DFS 深度优先算法
 */
public class Solution {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int len = candidates.length;
        if (len == 0) return res;
        // Sort
        for (int i=0;i<len;i++) {
            int minIndex = i;
            for (int j=i;j<len;j++) {
                if (candidates[j] < candidates[minIndex]) {
                    minIndex = j;
                }
            }
            int tmp = candidates[i];
            candidates[i] = candidates[minIndex];
            candidates[minIndex] = tmp;
        }

        List<Integer> sumList = new ArrayList<>();
        getSum(res, candidates, sumList, 0, target);
        return res;
    }


    public static void getSum(List<List<Integer>> res, int[] candidates,  List<Integer> sumList, int start, int target) {
        if (0 == target) {
            res.add(new ArrayList<>(sumList));
            return;
        }
        if (0 > target) {
            return;
        }
        for (int i=start; i<candidates.length; i++) {
            if (i>start && candidates[i] == candidates[i-1]) continue;
            sumList.add(candidates[i]);
            getSum(res, candidates, sumList, i+1, target - candidates[i]);
            sumList.remove(sumList.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] arr = {10,1,2,7,6,1,5};
        int target = 8;
        System.out.println(combinationSum2(arr, target));
    }
}
