package yucfeng.com;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.cn/problems/longest-substring-with-at-least-k-repeating-characters/
// 给你一个字符串 s 和一个整数 k ，请你找出 s 中的最长子串， 要求该子串中的每一字符出现次数都不少于 k 。返回这一子串的长度。
//
//如果不存在这样的子字符串，则返回 0。

public class Main {

    //分治：
    //    对于当前String s，历遍并将所有字符进行出现次数记录
    //    重新历遍String，如果发现其出现次数少于k，以当前i前后分别再调用longestSubstring(s.substring(0,i),k)以及longestSubstring(s.substring(i+1,s.length()),k)并取二者较大值
    //    如果没有小于k的字符，直接返回当前string长度
    //    完成分治之后直接返回
    public int longestSubstring(String s, int k) {
        int[] nums = new int[26];
        for (int i=0; i<s.length(); i++) {
            nums[s.charAt(i) - 'a'] ++;
        }
        for(int i = 0; i < s.length(); i++){
            if(nums[s.charAt(i)-'a'] < k){ // 出现分治点
                int l = longestSubstring(s.substring(0,i), k);
                int r = longestSubstring(s.substring(i+1), k);
                return Math.max(l,r);
            }
        }

        return s.length();

    }

    // 暴力
    public int longestSubstring2(String s, int k) {
        long start = System.currentTimeMillis();
        if (k > s.length()) return 0;
        Map<Character, Integer> charNums = new HashMap<>();

        int ans = 0;
        for (int l=0;l<l+k;l++) {
            for (int r=l+k; r<s.length(); r++) {
                String subStr = s.substring(l, r);
                putChar(charNums, subStr);
                if (match(charNums, k)) {
                    ans = Math.max(ans, r - l);
                }
            }
        }
        System.out.println(System.currentTimeMillis() - start + "ms");
        return ans;
    }

    public void putChar( Map<Character, Integer> charNums, String subStr) {
        for (Character c : subStr.toCharArray()) {
            if (charNums.containsKey(c)) {
                int temp = charNums.get(c) +1;
                charNums.put(c, temp);
            } else {
                charNums.put(c, 1);
            }
        }
    }

    public boolean match(Map<Character, Integer> charNums, int k) {
        return charNums.values().stream().allMatch(n -> n>=k);
    }

    @Test
    public void main() {
        System.out.println(longestSubstring("aaabb", 3));
    }
}