import org.junit.Test;

public class Solution {

//    public String maxDictionaryOrder2(String s) {
//        int[] hCounts = new int[s.length()];
//
//    }

    public String maxDictionaryOrder(String s) {
        if (s.length() <= 1) {
            return s;
        }
        char start = s.charAt(0);
        int startIndex = 0;
        StringBuilder ans = new StringBuilder(start + "");
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) > start) {
                start = s.charAt(i);
                startIndex = i;
                ans = new StringBuilder(start + "");
                continue;
            }
            if (s.charAt(i) == start) {
                ans.append(s.charAt(i));
                startIndex = i;
            }
        }
        return ans + maxDictionaryOrder(s.substring(startIndex + 1));
    }

    @Test
    public void test() {
        System.out.println(maxDictionaryOrder("cmbchina"));
        System.out.println(maxDictionaryOrder("aabcbccacbbcbaaba"));
//        System.out.println('a'-'0');
//        System.out.println('~' - 'z');

        System.out.println('0');
        System.out.println('9');

        System.out.println('A' - '0');
        System.out.println('Z' - '0');
        System.out.println('a' - '0');
        System.out.println('z' - '0');
    }
}
