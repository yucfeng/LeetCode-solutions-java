import java.util.*;
import java.util.stream.Collectors;

/*
Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 */
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> resMap = new HashMap<>();
        for (String str : strs) {
            boolean hasKey = false;
            for (String keyStr : resMap.keySet()) {
                if (isSameAnagram(keyStr, str)) {
                    resMap.get(keyStr).add(str);
                    hasKey = true;
                    break;
                }
            }
            if (!hasKey) {
                List<String> tmpList = new ArrayList<>();
                tmpList.add(str);
                resMap.put(str, tmpList);
            }
        }
        return new ArrayList<>(resMap.values());
    }

    private boolean isSameAnagram(String str1, String str2) {
        List<Character> chars1 = str1.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        for (char c : str2.toCharArray()) {
            if (!chars1.contains(c)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] ar) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        Solution solution = new Solution();
        System.out.println(solution.groupAnagrams(strs));
    }
}