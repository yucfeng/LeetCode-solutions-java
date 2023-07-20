/**
 * To determine how you "say" a digit string, split it into the minimal number of substrings such that each substring
 * contains exactly one unique digit.
 * Then for each substring, say the number of digits, then say the digit. Finally, concatenate every said digit.
 */
public class Solution {

    public String countAndSay(int n) {
        String prevStr = "1";
        for (int i = 2; i <= n; i++) {
            prevStr = convert(prevStr);
        }
        return prevStr;
    }

    public String convert(String s) {
        char prevCh = s.charAt(0);
        int prevCount = 1;
        StringBuilder ans = new StringBuilder();
        for (int i = 1; i < s.length(); i++) {
            char currCh = s.charAt(i);
            if (currCh != prevCh) {
                ans.append(prevCount);
                ans.append(prevCh);
                prevCount = 1;
                prevCh = currCh;
            }
            else {
                prevCount++;
            }
        }
        ans.append(prevCount);
        ans.append(prevCh);
        return ans.toString();
    }
}
