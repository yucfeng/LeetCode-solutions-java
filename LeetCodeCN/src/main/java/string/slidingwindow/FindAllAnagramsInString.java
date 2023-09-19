package string.slidingwindow;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

// https://leetcode.cn/problems/find-all-anagrams-in-a-string/
public class FindAllAnagramsInString {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new LinkedList<>();
        Map<Character, Integer> window = new HashMap<>(), need = new HashMap<>();
        for (char c : p.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int valid = 0; // 已覆盖的字符数量
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            while (right - left >= p.length()) {
                if (valid == need.size()) {
                    ans.add(left);
                }
                char d = s.charAt(left);
                left++;
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return ans;
    }
}
