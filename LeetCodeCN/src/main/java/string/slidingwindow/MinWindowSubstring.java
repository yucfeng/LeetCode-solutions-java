package string.slidingwindow;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.cn/problems/minimum-window-substring/
public class MinWindowSubstring {

    public String minWindow(String s, String t) {
        int sLen = s.length();
        Map<Character, Integer> window = new HashMap<>(), need = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0;
        int valid = 0; // 已覆盖的字符数量
        int start = 0, ansLen = Integer.MAX_VALUE;
        while (right < sLen) {
            char  c = s.charAt(right);
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            while (valid == need.size()) {
                if (right - left < ansLen) {
                    start = left;
                    ansLen = right - left;
                }

                char  remove = s.charAt(left);
                left++;
                if (need.containsKey(remove)) {
                    if (window.get(remove).equals(need.get(remove))) {
                        valid--;
                    }
                    window.put(remove, window.get(remove) - 1);
                }
            }
        }
        return ansLen == Integer.MAX_VALUE ? "" : s.substring(start, start + ansLen);
    }

    @Test
    public void test() {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }
}
