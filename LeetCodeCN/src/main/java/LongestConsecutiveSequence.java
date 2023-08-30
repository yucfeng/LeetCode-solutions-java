import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

// https://leetcode.cn/problems/longest-consecutive-sequence/
public class LongestConsecutiveSequence {

    // 时间复杂度为 O(n)
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num:nums) {
            set.add(num);
        }

        int ans = 0;
        for (int num:nums) {
            if (!set.contains(num-1)){  // HashSet#contains 时间复杂度为 O(1)
                int curStart = num;
                int cur = 1;

                while (set.contains(curStart+1)) {
                    curStart ++;
                    cur++;
                }
                ans = Math.max(cur, ans);
            }
        }

        return ans;
    }
}
