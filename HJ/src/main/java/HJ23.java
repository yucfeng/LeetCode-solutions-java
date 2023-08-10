import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HJ23 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 存放字母出现个数
        int[] count = new int[26];
        int min = Integer.MAX_VALUE;
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String s = in.nextLine();
            for (int i =0; i<s.length();i++){
                count[s.charAt(i) - 'a'] ++;

            }
            for (int i:count) {
                if (i==0)continue;
                min = Math.min(i, min);
            }
            for (int i=0; i<26;i++) {
                if (count[i] == min) {
                    s = s.replaceAll(String.valueOf((char)(i+'a')), "");
                }
            }
            System.out.println(s);
        }
    }
}
