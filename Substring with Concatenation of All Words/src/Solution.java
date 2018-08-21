/**
 * You are given a string, s, and a list of words.
 * Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once
 * and without any intervening characters.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        Map<String, Integer> counts = new HashMap<>();
        if (words.length == 0) return res;
        for (String word : words) {
            counts.put(word, counts.getOrDefault(word, 0) + 1);
        }
        int num = words.length, len = words[0].length();
        for (int i = 0; i < s.length() - num * len + 1; i++) {  //
            Map<String, Integer> seen = new HashMap<>();
            int j = 0;
            while (j < num) {
                String word = s.substring(i + j * len, i + (j + 1) * len);  //
                if (counts.containsKey(word)) {
                    seen.put(word, seen.getOrDefault(word, 0) + 1);
                    if (seen.get(word) > counts.get(word)) {
                        break;
                    }
                } else {
                    break;
                }
                j++;
            }
            if (j == num) {
                res.add(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "wordgoodgoodgoodbestword";
        String[] words = {"word", "good", "best", "good"};
//        int first = s.indexOf(words[0]);
//        System.out.println(s.substring(first+words[0].length()));
        System.out.println(findSubstring(s, words));
    }
}
