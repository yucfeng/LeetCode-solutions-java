import org.junit.Test;

import java.util.Arrays;

/*
https://leetcode-cn.com/problems/permutation-sequence/
"123"
"132" 2
"213" 3
"231"
"312"
"321"

"13" 1
"31"
 */
/*
"1234"
"1243"
"1324"
"1342"
"1423"
"1432"
"2134"
"2143"
"2314" 9
"2341"
"2413"
"2431"

 */
public class Solution {

    public String getPermutation(int n, int k) {
        // 题目中说给定 n 的范围是 [1, 9]，可以把从 0 到 9 的阶乘计算好，放在一个数组里，可以根据索引直接获得阶乘值
        // 快速计算阶乘
        int[] factorial = new int[n];
        factorial[0] = 1;
        for (int i = 1; i < n; ++i) {
            factorial[i] = factorial[i - 1] * i;
        }

        --k;
        StringBuilder ans = new StringBuilder();
        int[] valid = new int[n + 1];
        Arrays.fill(valid, 1);
        for (int i = 1; i <= n; ++i) {
            int order = k / factorial[n - i] + 1;
            for (int j = 1; j <= n; ++j) {
                order -= valid[j];
                if (order == 0) {
                    ans.append(j);
                    valid[j] = 0;
                    break;
                }
            }
            k %= factorial[n - i];
        }
        return ans.toString();
    }
// 回溯法容易超时
//    public String getPermutation(int n, int k) {
//        if (k==1) {
////            return nums;
//        }
//        int a = k/factorial(n-1);
//        int b = k % n;
//        // 首位
//        int first;
//        if (b > 0) {
//            first = a + 1;
//            k = b;
//        } else {
//            first = a;
//            k = factorial(n-1);
//        }
//
//
//        char[] nums = (n+"").toCharArray();
//
//        // remove first from nums
//
//        return "";
//    }
//
//    private String getPermutation2(char[] nums, int n, int k) {
//        if (n == 2 && k ==2) {
//            return String.valueOf(nums[1]) + String.valueOf(nums[0]);
//        }
//
//    }

    public static int factorial(int num) {
        int sum = 1;
        if (num < 0)
            throw new IllegalArgumentException("must be positive");
        if (num == 1 || num == 0) {
            return 1;
        } else {
            sum = num * factorial(num - 1);
            return sum;
        }
    }

    @Test
    public void test() {
        System.out.println(getPermutation(4, 9));
    }
}
