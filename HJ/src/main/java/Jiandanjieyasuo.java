import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * 简单的解压缩算法
 * 解题思路：
 * 使用栈来处理，本题就是逻辑麻烦一些
 * 遍历字符数组，如果当前字符是非数字，那么入栈，
 * 否则，就向后先把数字获取出来，然后分情况将栈里的字符取出来后，倒序成字符串，再按照数字的倍数拼接
 */
public class Jiandanjieyasuo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        char[] chars = line.toCharArray();
        int len = chars.length;
        Deque<Character> stack = new ArrayDeque<>(len);

        int i = 0;
        while (i <= len - 1) {
            char currChar = chars[i];
            //如果不是数字，则入栈
            if (!Character.isDigit(currChar)) {
                stack.push(currChar);
                i++;
                continue;
            }

            //如果是数字
            if (Character.isDigit(currChar)) {
                String str = "";
                //先获取数字前面的字符串
                if (chars[i - 1] == '}') {
                    //取括号里的字符串
                    str = getStrWithMark(stack);
                } else {
                    str = getOnlyLetterStr(stack);
                }
                StringBuilder sbNum = new StringBuilder();
                while (i < len && Character.isDigit(chars[i])) {
                    sbNum.append(chars[i]);
                    i++;
                }
                int n = Integer.parseInt(sbNum.toString());
                //将前面的字符串，n倍拼接
                String s = getNumTimes(str, n);
                //放入栈里面
                for (int j = 0; j < s.length(); j++) {
                    stack.push(s.charAt(j));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        String string = sb.reverse().toString();
        System.out.println(string);


    }

    //获取数字前面括号里面的内容
    public static String getStrWithMark(Deque<Character> stack) {
        StringBuilder sb = new StringBuilder();
        if (stack.peek() == '}') {
            stack.pop();
        }
        while (stack.peek() != '{') {
            char c = stack.pop();
            sb.append(c);
        }
        if (stack.peek() == '{') {
            stack.pop();
        }
        String s = sb.reverse().toString();
        return s;
    }

    //获取数字前面的字符串
    public static String getOnlyLetterStr(Deque<Character> stack) {
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty() && stack.peek() != '{') {
            char c = stack.pop();
            sb.append(c);
        }
        String s = sb.reverse().toString();
        return s;
    }

    public static String getNumTimes(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(s);
        }
        return sb.toString();
    }

}

