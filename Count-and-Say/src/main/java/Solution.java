import org.junit.Test;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/count-and-say/
 */
public class Solution {

    @Test
    public void test() {
        System.out.println(countAndSay(6));
    }

    // nums[10][2] = [[a, b], []. ....]
    // a - n的个数
    // b - n出现的顺位
    public String countAndSay(int n) {
        String output = "1";
        if (n==1) {
            return output;
        } else {
            String last = countAndSay(n-1);
            int[][] nums = new int[10][2];
            int place = 0;
            for (int i = 0; i < last.length(); i++) {
                int t = Integer.parseInt(String.valueOf(last.charAt(i)));
                if (nums[t][1] == 0) {
                    nums[t][1] = ++place;
                }
                nums[t][0] = nums[t][0]+1;
            }
            return generateStr(nums);
        }
    }

    // strArr[10][2] = [[a, b], []. ....]
    // a - 次数
    // b - 数字
    private String generateStr(int[][] nums) {
        StringBuilder sb = new StringBuilder();
        int[][] strArr = new int[30][2];
        for (int i = 0; i < 10; i++) {
            if (nums[i][0] == 0) {
                continue;
            }
            strArr[nums[i][1]] = new int[]{nums[i][0], i};
        }
        for (int i = 1; i < strArr.length; i++) {
            if (strArr[i][0] == 0) {
                break;
            }
            sb.append(strArr[i][0]).append(strArr[i][1]);
        }
        return sb.toString();
    }
}
