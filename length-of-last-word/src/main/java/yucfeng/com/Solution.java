package yucfeng.com;

public class Solution {
    public int lengthOfLastWord(String s) {
        int res = 0;
        String r = s.trim();
        if (r.length() == 0) {
            return 0;
        }
        for (int i=r.length()-1;i>=0;i--) {
            if (s.charAt(i) != ' ') {
                res++;
            } else {
                break;
            }
        }
        return res;
    }
}
