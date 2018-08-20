import java.util.Stack;

/**
 * Given a string containing just the characters '(' and ')',
 * find the length of the longest valid (well-formed) parentheses substring. ((()(()))
 */

public class Solution {
    public static int longestValidParentheses(String s) {
        int res = 0;
        if (s.length() < 1) return res;
        Stack stack = new Stack();
        int cur = 0;
        stack.push(-1);
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == ')' && stack.size() > 1 && s.charAt((int)stack.peek()) == '(') {
                stack.pop();
                res = Math.max(res, i - (int)stack.peek());
            } else {
                stack.push(i);
            }
        }
        return res;
    }

    public static void main(String[] agrs) {
        System.out.print(longestValidParentheses("((()(()()"));
    }
}
