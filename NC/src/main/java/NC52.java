import java.util.Stack;

public class NC52 {

    public boolean isValid (String s) {
        Stack<Character> stack = new Stack<>();
        for (int i=0; i< s.length(); i++) {
            if (stack.isEmpty() || (!isMatched(stack.peek(), s.charAt(i)))) {
                stack.push(s.charAt(i));
                continue;
            }
            if (isMatched(stack.peek(), s.charAt(i))) {
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public boolean isMatched(Character a, Character b) {
        return (a == '(' && b == ')') || (a == '[' && b == ']') || (a=='{'&&b=='}');
    }
}
