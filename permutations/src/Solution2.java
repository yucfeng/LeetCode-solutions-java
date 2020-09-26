import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Given a collection of distinct integers, return all possible permutations.
 * 3! = 6
 * 4 * 3！ = 24
 */
class Solution2 {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

//        for (int i = 0; i < simpleCircle(len - 1); i++) {
//            res.add(new ArrayList<>());
//        }
        return add(res, nums);
    }

    private static List<List<Integer>> add(List<List<Integer>> res, int[] nums) {
        int len = nums.length;
        if (len == 0) return res;
        for (int n : nums) {
            res.forEach(list -> {
                if (!list.contains(n)) {
                    list.add(n);
                }
            });
//
//
//                if (res.size() <= i) {
//                    res.add(Collections.singletonList(n));
//                } else {
//                    res.get(i).add(n);
//                }
//            }
            add(res, remove(nums));
        }
        return res;
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
        int[] a = {1, 2, 3};
        System.out.println(permute(a));
    }
}