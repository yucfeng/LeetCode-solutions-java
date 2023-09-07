import org.junit.Test;

import java.util.*;

// https://leetcode.cn/problems/3sum
public class Sum3 {
    // [-4, -3, -2, -1, -1, 0, 0, 1, 2, 3, 4]
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        for (int first = 0; first < len; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }

            int third = len - 1;
            int n = -nums[first];
            for (int second = first + 1; second < len; second++) {
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                while (second < third && nums[second] + nums[third] > n) {
                    third--;
                }
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == n) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }

        return ans;
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            if (nums[i] + nums[i + 1] + nums[i + 2] > 0) break;
            if (nums[i] + nums[len - 2] + nums[len - 1] < 0) continue;

            int cur = -nums[i];
            int l = i + 1;
            int r = len - 1;
            while (l < r) {
                if (nums[l] + nums[r] == cur) {
                    ans.add(List.of(nums[i], nums[l], nums[r]));
                    l++;
                    while (l < r && nums[l] == nums[l - 1]) {
                        l++;
                    }
                    r--;
                    while (l < r && nums[r] == nums[r + 1]) {
                        r--;
                    }
                }
                if (nums[l] + nums[r] > cur) {
                    r--;
                }
                if (nums[l] + nums[r] < cur) {
                    l++;
                }
            }
        }
        return ans;
    }

    public int binary(int[] nums, int n, int l, int r) {
        while (r > l + 1) {
            if (nums[(r + l) / 2] > n) {
                r = (r + l) / 2;
            } else if (nums[(r + l) / 2] < n) {
                l = (r + l) / 2;
            } else {
                return (r + l) / 2;
            }
        }
        return nums[(r + l) / 2] < n ? -2 : -1;
    }

    @Test
    public void test() {
        System.out.println(threeSum2(new int[]{-1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4}));
    }
}
