import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

// https://leetcode.cn/problems/4sum/
public class Sum4 {

    // 注意int 类型溢出
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        int len = nums.length;
        for (int i = 0; i < len - 3; i++) {
            long a = nums[i];
            if (i > 0 && a == nums[i - 1]) continue;
            if (a + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) break;
            if (a + nums[len - 3] + nums[len - 2] + nums[len - 1] < target) continue;
            for (int j = i + 1; j < len - 2; j++) {
                long b = nums[j];
                if (j > i + 1 && b == nums[j - 1]) continue;
                if (a + b + nums[j + 1] + nums[j + 2] > target) break;
                if (a + b + nums[len - 2] + nums[len - 1] < target) continue;

                int cur = target - nums[i] - nums[j];
                int l = j + 1, r = len - 1;
                while (l < r) {
                    long cd = nums[l] + nums[r];
                    if (cd == cur) {
                        ans.add(List.of(nums[i], nums[j], nums[l], nums[r]));
                        l++;
                        while (l < r && nums[l] == nums[l - 1]) {
                            l++;
                        }
                        r--;
                        while (l < r && nums[r] == nums[r + 1]) {
                            r--;
                        }
                    }
                    if (cd > cur) {
                        r--;
                    }
                    if (cd < cur) {
                        l++;
                    }
                }
            }
        }
        return ans;
    }

    LinkedList<Integer> idxList = new LinkedList<>();
    int start = 0;

    private void f(List<List<Integer>> ans, int[] nums, int target) {
        if (idxList.size() == 4) {
            if (target == 0) {
                List<Integer> tmp = idxList.stream().map(n -> nums[n]).collect(Collectors.toList());
                ans.add(tmp);
                return;
            }
            return;
        }

        int next = idxList.isEmpty()? start : idxList.getLast() + 1;
        if (next >= nums.length) return;
        if (nums[next] > target) return;

        idxList.add(next);
        f(ans, nums, target - nums[next]);
        idxList.removeLast();
        if (idxList.isEmpty()) {
            start++;
        }
    }

    @Test
    public void test() {
//        System.out.println(fourSum(new int[] {0,0,0,1000000000,1000000000,1000000000,1000000000}, 1000000000));
        int n = 14;
        System.out.println(n>>3);
        System.out.println(n & 0x07);
        System.out.println(n & 7);
        System.out.println(~ 0x07);
    }
}
