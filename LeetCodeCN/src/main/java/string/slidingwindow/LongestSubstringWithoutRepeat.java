package string.slidingwindow;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// https://leetcode.cn/problems/longest-substring-without-repeating-characters
public class LongestSubstringWithoutRepeat {

    public int lengthOfLongestSubstring(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int right = 0, ans = 0;
        for (int left = 0; left < n; ++left) {
            if (left != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(left - 1));
            }
            while (right < n && !occ.contains(s.charAt(right))) {
                // 不断地移动右指针
                occ.add(s.charAt(right));
                ++right;
            }
            // 第 left 到 right 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, right - left);
        }
        return ans;
    }

    public int lengthOfLongestSubstring2(String s) {
        Map<Character, Integer> window = new HashMap<>();

        int left = 0, right = 0;
        int ansLen = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            window.put(c, window.getOrDefault(c, 0) + 1);

            while (window.get(c) > 1) {
                char d = s.charAt(left);
                left++;
                if (window.containsKey(d)) {
                    window.put(d, window.get(d) - 1);
                }
            }
            ansLen = Math.max(ansLen, right - left);
        }
        return ansLen;
    }

    @Test
    public void test() {
        System.out.println(lengthOfLongestSubstring("aab"));
    }
}
