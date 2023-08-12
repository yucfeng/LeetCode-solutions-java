import org.junit.Test;

import java.util.*;

public class ThreeSum {
    // [-4, -3, -2, -1, -1, 0, 0, 1, 2, 3, 4]
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        for (int first = 0; first < len; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }

            int third = len-1;
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

    public List<List<Integer>> threeSumWrong(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>();
        Arrays.sort(nums);
        int len = nums.length;
        int l = 0;
        int r = len - 1;
        while (r > l) {
            int n = -(nums[r] + nums[l]);
            int index = binary(nums, n, l, r);
            if (index > -1) {
                List<Integer> set = Arrays.asList(nums[l], nums[index], nums[r]);
                ans.add(set);
                if (index - l < r -index) {
                    r--;
                } else {
                    l++;
                }
            } else if (index == -2) {
                l++;
            } else if (index == -1) {
                r--;
            }
        }

        return new ArrayList<>(ans);
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
        System.out.println(threeSum(new int[]{-1,0,1,2,-1,-4,-2,-3,3,0,4}));
    }
}
