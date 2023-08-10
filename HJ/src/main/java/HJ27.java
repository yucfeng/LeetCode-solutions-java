import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// 查找兄弟单词
public class HJ27 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String[] a = in.nextLine().split(" ");
            if (a.length < 3) {
                continue;
            }
            int n = Integer.parseInt(a[0]);
            String x = a[a.length - 2];
            int k = Integer.parseInt(a[a.length - 1]);


            String[] ss = Arrays.copyOfRange(a, 1, a.length - 2);
            Arrays.sort(ss);
            List<String> ans = new ArrayList<>();
            for (String s : ss) {
                if (matched(x, s)) {
                    ans.add(s);
                }
            }

            System.out.println(ans.size());
            if (ans.size() >= k) {
                System.out.println(ans.get(k - 1));
            }
        }
    }

    private static boolean matched(String x, String s) {
        if (x.equals(s)) return false;
        if (x.length() != s.length()) return false;
        char[] xc = x.toCharArray();
        char[] sc = s.toCharArray();
        Arrays.sort(xc);
        Arrays.sort(sc);
        return new String(sc).equals(new String(xc));
    }
}
