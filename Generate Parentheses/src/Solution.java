import java.util.*;

/**
 *  Given n pairs of parentheses,
 *  write a function to generate all combinations of well-formed parentheses.
 *  Author: yucfeng
 *  Date: 2018/5/29
 */
public class Solution {

    public static List<String> generateParenthesis(int n) {
        List<String> res = generate(n);
        return res;
    }

    private static List<String> generate(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) {
            res.add("");
            return res;
        }
        if (n == 1) {
            res.add("()");
            return res;
        }
        for (int i=1; i<=n; i++) {
            List<String> heads = new ArrayList<>();
            for (String s : generate(i-1)) {
                heads.add("("+s+")");
            }
            List<String> tails = generate(n-i);
            for (String head : heads) {
                for (String tail: tails) {
                    res.add(head+tail);
                }
            }
        }
        return res;
    }

    public static void main(String[] agrs) {
        System.out.println(generateParenthesis(3));
    }
}
