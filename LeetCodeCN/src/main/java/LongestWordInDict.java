import org.junit.Test;

import java.util.*;

// https://leetcode.cn/problems/longest-word-in-dictionary/
public class LongestWordInDict {

    public String longestWord(String[] words) {
        int len = words.length;
        String ans = "";
        Arrays.sort(words, (a, b) -> {
            if (a.length() != b.length()) return a.length() - b.length();
            else return b.compareTo(a);
        });
        if (words[0].length() != 1) return ans;
        if (len == 1) return words[0];

        Set<String> set = new HashSet<>();
        set.add(ans);
        for (String s : words) {
            if (set.contains(s.substring(0, s.length()-1))) {
                set.add(s);
                ans = s;
            }
        }
        return ans;
    }

    public String longestWord2(String[] words) {
        int len = words.length;
        Arrays.sort(words);
        if (words[0].length() != 1) return "";
        if (len == 1) return words[0];

        int ansIdx = len - 1;
        boolean invalid = false;
        for (int i = len - 1; i >= 0; i--) {
            if (i == 0) {
                invalid = true;
                break;
            }
            String cur = words[i];

            String prev = cur.substring(0, cur.length() - 1);
            if (words[i - 1].startsWith(prev)) {
                if (words[i - 1].length() == cur.length()) {
                    ansIdx = i - 1;
                }
            } else {
                ansIdx--;
            }
        }

        if (invalid) return words[ansIdx];
        return "";
    }

    @Test
    public void test() {
        String[] wrs = new String[]{"a","banana","app","appl","ap","apply","apple"};
        System.out.println(longestWord(wrs));
    }
}
