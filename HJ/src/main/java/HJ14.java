import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 字符串排序
public class HJ14 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        List<String> ans = new ArrayList<>();
        while (ans.size() < n) {
            ans.add(in.nextLine());
        }

        ans.sort((s1, s2) -> compare(s1, s2));
        for (String s : ans) {
            System.out.println(s);
        }

        in.close();
    }

    private static int compare(String s1, String s2) {
        if (s1.equals(s2)) return 0;
        int len = Math.min(s1.length(), s2.length());
        for (int i=0;i<len;i++) {
            if (s1.charAt(i) == s2.charAt(i)){
                continue;
            }
            return s1.charAt(i) - s2.charAt(i);
        }
        return s1.length() - s2.length();
    }
}
