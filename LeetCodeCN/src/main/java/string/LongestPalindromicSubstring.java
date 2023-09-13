package string;

// https://leetcode.cn/problems/longest-palindromic-substring/
public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        String ans = "";
        for (int i=0; i<s.length();i++) {
            String sub1 = findPalindrome(s, i, i);
            String sub2 = findPalindrome(s, i, i+1);
            ans = ans.length() > sub1.length() ? ans : sub1;
            ans = ans.length() > sub2.length() ? ans : sub2;
        }
        return ans;
    }

    private String findPalindrome(String s, int l, int r) {
        while (l>=0 && r<s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return s.substring(l+1, r);
    }
}
