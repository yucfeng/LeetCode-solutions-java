import java.util.ArrayList;
import java.util.List;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 An input string is valid if:
 Open brackets must be closed by the same type of brackets.
 Open brackets must be closed in the correct order.
 Note that an empty string is also considered valid.
 * Author: yucfeng
 * Date: 2018/5/25
 */
public class Solution {

    public boolean isValid(String s) {
        int len = s.length();
        if (len == 0) return true;
        if (len%2 != 0) return false;
        List<Character> chars = new ArrayList<>();
        chars.add(s.charAt(0));
        for (int i=1; i<len; i++) {
            if (chars.size()!=0 && bracketsMatch(chars.get(chars.size()-1), s.charAt(i))) chars.remove(chars.size()-1);
            else chars.add(s.charAt(i));
        }
        if (chars.size() == 0) return true;
        else return false;
    }

    public boolean bracketsMatch(Character left, Character right){
        if (left == '(' && right == ')') return true;
        if (left == '[' && right == ']') return true;
        if (left == '{' && right == '}') return true;
        return false;
    }
}
