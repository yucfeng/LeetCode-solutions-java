import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Zimuzuhe {

    public static String forbiddenStr;
    public static char[][] chars = {
            {'a', 'b', 'c'},
            {'d', 'e', 'f'},
            {'g', 'h', 'i'},
            {'j', 'k', 'l'},
            {'m', 'n', 'o'},
            {'p', 'q', 'r'},
            {'s', 't'},
            {'u', 'v'},
            {'w', 'x'},
            {'y', 'z'}
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String numStr = sc.nextLine();

        char[] numArray = numStr.toCharArray();
        forbiddenStr = sc.nextLine();
        List<String> list = new ArrayList<>();
        dfs(list, numArray, "", 0);

        //打印字符串
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            //注意题目，最后是有逗号的","
            sb.append(list.get(i)).append(",");
        }
        System.out.println(sb);

    }

    /**
     * 从numIndex开始, 拼接numArray[numIndex]数字 对应的字符，按顺序，所以不用回溯
     * @param list 存放满足条件的字符串
     * @param numArray 数字的数组
     * @param temp 已经拼接的字符串
     * @param numIndex 数字的下标
     */
    public static void dfs(List<String> list, char[] numArray, String temp, int numIndex) {
        if (temp.length() == numArray.length) {
            //如果不包含禁止的字符串，那么可以保留
            if (!temp.contains(forbiddenStr)) {
                list.add(temp);
            }
            return;
        }
        //注意，这里每次只能去一个，得按照数字顺序来（注意: 千万不能for循环numArr）
        int num = numArray[numIndex] - '0';
        char[] charArr = chars[num];
        for (char curr : charArr) {
            dfs(list, numArray, temp + curr, numIndex + 1);
        }

    }
}
