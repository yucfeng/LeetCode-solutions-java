import java.util.Stack;

/*
https://leetcode.cn/problems/maximum-nesting-depth-of-the-parentheses/
valid parentheses string
 */
public class Solution1614 {
    public int maxDepth(String s) {
        int ans = 0;
        Stack<Character> stack = new Stack<>();
        for (int i =0; i< s.length(); i++){
            if (s.charAt(i) == '(') {
                stack.push(s.charAt(i));
                continue;
            }
            if (s.charAt(i) == ')') {
                ans = Math.max(ans, stack.size());
                stack.pop();
            }
        }
        return ans;
    }
}
